

Logos {
	classvar <>location=\logos;
	classvar <instrumentList;

	*initClass {
		// Load instruments from separate file
		instrumentList = LogosInstruments.instrumentSpecs;

		// Register event type
		this.registerEventType;
	}

	// Core translation method - used by both event type and manual translation
	*translateLogosEvent { |event, shouldPlay = true|
		var instrSpec, midiout, chan, microtone=0, midiEvents, noteEvent, bendEvent, bend, newEvent;

		midiEvents = [];

		// Get instrument specification
		instrSpec = this.instrumentList[event[\instrument]];
		if(instrSpec.isNil) {
			"Logos instrument % not found".format(event[\instrument]).warn;
			^[];
		};

		// Get MIDI output and channel - common to all events
		midiout = this.midiout(instrSpec.port, event[\location] ? \logos);
		chan = instrSpec.chan;
		if(chan.isArray) {
			chan = chan[0]; // Use first channel for now
		};

		// create the type, midiout and channel
		newEvent = event.copy.putAll((\type: \midi, \midiout: midiout, \chan: chan, \channel: chan, \dur: Rest(0))); // rest 0 just in case // channel should be avoided - check renderMIDI


		// Handle note events if midinote is present
		if(event.keys.includes(\midinote) || event.keys.includes(\degree) || event.keys.includes(\note) && {event[\midinote] != \rest}) {

			if(event[\midinote].isKindOf(Function)){
				event[\midinote] = event[\midinote].value.asInteger;
			};


			// Create main note event
			noteEvent = newEvent.copy;
			noteEvent = noteEvent.putAll((\midinote: event[\midinote], \dur: event.dur, \velocity: event.velocity ? 64, \amp: {event.velocity ? 64 / 127}, \mul: 1)); // TO DO

			// Handle microtuning if specified
			if(instrSpec.tuning.notNil && {instrSpec.tuning.microtuning.notNil}) {

				microtone = (noteEvent[\midinote] ? 0) % 1;
				if(microtone.isNil){microtone = 0};

				switch(instrSpec.tuning.microtuning.ctl,
					\pitchBend, {
						if(microtone <= 0.5) {
							bend = microtone.linlin(0, 0.5, 8192, 16384).asInteger;
						} {
							noteEvent[\midinote] = noteEvent[\midinote].asInteger + 1;
							bend = microtone.linlin(0.5, 1, 0, 8192).asInteger;
						};

						// Create pitch bend event
						bendEvent = (
							type: \midi,
							midiout: midiout,
							chan: chan,
							midicmd: \bend,
							val: bend.asInteger,
							dur: 0
						);
					},
					\polyTouch, {
						if(microtone <= 0.5) {
							bend = 64 + (microtone / 0.5 * 63);
						} {
							event[\midinote] = event[\midinote].asInteger + 1;
							bend = 64 - ((1 - microtone) / 0.5 * 64);
						};

						// Mark for poly touch (would need additional handling)
						event[\logosMicroTouchVal] = bend.asInteger;
					}
				);

			};

			if(bendEvent.notNil){
				var newPattern = Ptpar([0, Pseq([noteEvent]), 1/1024, Pseq([bendEvent])]);

				if(shouldPlay) {
					//noteEvent.postln;
					noteEvent.play;
					bendEvent.play;
				};

				// convert to events for conversion with SimpleMIDIFile
				midiEvents.add(newPattern.toArray);
			}{

				if(shouldPlay) { noteEvent.play };
				^midiEvents.add(noteEvent);
			};

		};


		// Handle Logos-specific controls
		if(event[\power].notNil && {instrSpec.power.notNil}) {
			newEvent = newEvent.putAll((
				midicmd: \control,
				ctlNum: instrSpec.power.ctlNum,
				dur: 0,
				control: event[\power].asInteger,

			));
		};

		// MARKER FOR DEFAULT

		// add bend events: TO DO - adjust bendwidth for instruments with halfstep bend:
		if(event[\bend].notNil && {instrSpec.tuning.notNil} && {instrSpec.tuning.microtuning.notNil} && {instrSpec.tuning.microtuning.ctl == \pitchBend}) {

			newEvent = newEvent.putAll((
				midicmd: \bend,
				dur: event[\dur],
				val: event[\bend].linlin(-1, 1, 0, 16384).asInteger,
			));
		};


		if(instrSpec.dynamics.notNil){

			// add wind controller:
			if(event[\wind].notNil && {instrSpec.dynamics.wind.notNil} && {instrSpec.dynamics.wind.ctlNum.notNil}) {
				newEvent = newEvent.putAll((
					midicmd: \control,
					ctlNum: instrSpec.dynamics.wind.ctlNum,
					dur: event[\dur],
					control: event[\wind].asInteger,
				));
			};


			if(event[\scaling].notNil && {instrSpec.dynamics.scaling.notNil} && {instrSpec.dynamics.scaling.ctlNum.notNil}) {
				newEvent = newEvent.putAll((
					midicmd: \control,
					ctlNum: instrSpec.dynamics.scaling.ctlNum,
					dur: event[\dur],
					control: event[\scaling].asInteger,
				));
			};


			// add adsr controller:
			if(instrSpec.dynamics.adsr.notNil){

				// a
				if(instrSpec.dynamics.adsr.a.notNil){
					if(event[\a].notNil && {instrSpec.dynamics.adsr.a.notNil} && {instrSpec.dynamics.adsr.a.ctlNum.notNil}) {
						newEvent = newEvent.putAll((
							midicmd: \control,
							ctlNum: instrSpec.dynamics.adsr.a.ctlNum,
							dur: event[\dur],
							control: event[\a].asInteger,
						));
					};

					if(event[\aAmp].notNil && {instrSpec.dynamics.adsr.a.amp.notNil} && {instrSpec.dynamics.adsr.a.amp.ctlNum.notNil}) {
						newEvent = newEvent.putAll((
							midicmd: \control,
							ctlNum: instrSpec.dynamics.adsr.a.amp.ctlNum,
							dur: event[\dur],
							control: event[\aAmp].asInteger,
						));
					};

				};

				// d
				if(event[\d].notNil && {instrSpec.dynamics.adsr.d.notNil} && {instrSpec.dynamics.adsr.d.ctlNum.notNil}) {
					newEvent = newEvent.putAll((
						midicmd: \control,
						ctlNum: instrSpec.dynamics.adsr.d.ctlNum,
						dur: event[\dur],
						control: event[\d].asInteger,
					));
				};

				// s
				if(event[\s].notNil && {instrSpec.dynamics.adsr.s.notNil} && {instrSpec.dynamics.adsr.s.ctlNum.notNil}) {
					newEvent = newEvent.putAll((
						midicmd: \control,
						ctlNum: instrSpec.dynamics.adsr.s.ctlNum,
						dur: event[\dur],
						control: event[\s].asInteger,
					));
				};

				// r
				if(event[\r].notNil && {instrSpec.dynamics.adsr.r.notNil} && {instrSpec.dynamics.adsr.r.ctlNum.notNil}) {
					newEvent = newEvent.putAll((
						midicmd: \control,
						ctlNum: instrSpec.dynamics.adsr.d.ctlNum,
						dur: event[\dur],
						control: event[\r].asInteger,
					));
				};

				// period
				if(event[\period].notNil && {instrSpec.dynamics.adsr.period.notNil} && {instrSpec.dynamics.adsr.period.ctlNum.notNil}) {
					newEvent = newEvent.putAll((
						midicmd: \control,
						ctlNum: instrSpec.dynamics.adsr.period.ctlNum,
						dur: event[\dur],
						control: event[\period].asInteger,
					));
				};
			}; // end ADSR


			// add tremolo:
			if(instrSpec.dynamics.tremolo.notNil){

				if(event[\tremoloSpeed].notNil && {instrSpec.dynamics.tremolo.speed.notNil} && {instrSpec.dynamics.tremolo.speed.ctlNum.notNil}) {
					newEvent = newEvent.putAll((
						midicmd: \control,
						ctlNum: instrSpec.dynamics.tremolo.speed.ctlNum,
						dur: event[\dur],
						control: event[\tremoloSpeed].asInteger,
					));
				};

				if(event[\tremoloDepth].notNil && {instrSpec.dynamics.tremolo.depth.notNil} && {instrSpec.dynamics.tremolo.depth.ctlNum.notNil}) {
					newEvent = newEvent.putAll((
						midicmd: \control,
						ctlNum: instrSpec.dynamics.tremolo.depth.ctlNum,
						dur: event[\dur],
						control: event[\tremoloDepth].asInteger,
					));
				};

			}; // end Tremolo


		}; // end dynamics

		// add vibrato
		if(instrSpec.tuning.notNil && {instrSpec.tuning.vibrato.notNil}){

			if(event[\vibratoSpeed].notNil && {instrSpec.tuning.vibrato.speed.notNil} && {instrSpec.tuning.vibrato.speed.ctlNum.notNil}) {
				newEvent = newEvent.putAll((
					midicmd: \control,
					ctlNum: instrSpec.tuning.vibrato.speed.ctlNum,
					dur: event[\dur],
					control: event[\vibratoSpeed].asInteger,
				));
			};

			if(event[\vibratoDepth].notNil && {instrSpec.tuning.vibrato.depth.notNil} && {instrSpec.tuning.vibrato.depth.ctlNum.notNil}) {
				newEvent = newEvent.putAll((
					midicmd: \control,
					ctlNum: instrSpec.tuning.vibrato.depth.ctlNum,
					dur: event[\dur],
					control: event[\vibratoDepth].asInteger,
				));
			};

		}; // end Vibrato

		// add filter
		if(instrSpec.sound.notNil && {instrSpec.sound.filter.notNil}){

			// add filter - frequency:
			if(event[\filterFreq].notNil && {instrSpec.sound.filter.frequency.notNil}) {
				newEvent = newEvent.putAll((
					midicmd: \control,
					ctlNum: instrSpec.sound.filter.frequency.ctlNum,
					dur: event[\dur],
					control: event[\filterFreq],
				));
			};
			// add filter - frequency:
			if(event[\filterQ].notNil && {instrSpec.sound.filter.q.notNil}) {
				newEvent = newEvent.putAll((
					midicmd: \control,
					ctlNum: instrSpec.sound.filter.q.ctlNum,
					dur: event[\dur],
					control: event[\filterQ],
				));
			};
			// add filter - lfo:
			if(event[\filterLFO].notNil && {instrSpec.sound.filter.lfo.notNil} && {instrSpec.sound.filter.lfo.frequency.notNil}) {
				newEvent = newEvent.putAll((
					midicmd: \control,
					ctlNum: instrSpec.sound.filter.lfo.frequency.ctlNum,
					dur: event[\dur],
					control: event[\filterLFO],
				));
			};
			// add filter - lfo depth
			if(event[\filterLFODepth].notNil && {instrSpec.sound.filter.lfo.notNil} && {instrSpec.sound.filter.lfo.depth.notNil}) {
				newEvent = newEvent.putAll((
					midicmd: \control,
					ctlNum: instrSpec.sound.filter.lfo.depth.ctlNum,
					dur: event[\dur],
					control: event[\filterLFODepth],
				));
			};

		};

		// add ECHO
		if(instrSpec.sound.notNil && {instrSpec.sound.echo.notNil}){

			// add echo - mix
			if(event[\echoMix].notNil && {instrSpec.sound.echo.mix.notNil}) {
				newEvent = newEvent.putAll((
					midicmd: \control,
					ctlNum: instrSpec.sound.echo.mix.ctlNum,
					dur: event[\dur],
					control: event[\echo],
				));
			};

			// add echo - feedback
			if(event[\echoFeedback].notNil && {instrSpec.sound.echo.feedback.notNil}) {
				newEvent = newEvent.putAll((
					midicmd: \control,
					ctlNum: instrSpec.sound.echo.feedback.ctlNum,
					dur: event[\dur],
					control: event[\echoFeedback],
				));
			};

		}; // end ECHO




		// Handle explicit control changes
		if(event[\ctlNum].notNil && {event[\control].notNil}) {
			newEvent = newEvent.putAll((
				midicmd: \control,
				ctlNum: event[\ctlNum].asInteger,

				control: event[\control].asInteger,
			));

		};

		midiEvents = midiEvents.add(newEvent);
		if(shouldPlay) { newEvent.play };

		^midiEvents;
	}

	*registerEventType {
		Event.addEventType(\logos, {|server|
			var instrSpec, midiout, chan, microtone, noteEvent, bendEvent;

			this.translateLogosEvent(currentEnvironment);

		});
	}

	*toMIDI { |event|
		// Use the shared translation method with shouldPlay = false
		^this.translateLogosEvent(event, false);
	}

	*toSimpleMIDIFile {|pattern, maxEvents=10000|
		var logosEvents = pattern.toArray(maxEvents), midiEvents;

		midiEvents = logosEvents.collect { |event|
			if(event[\type] == \logos) {
				var newEvent;

				newEvent = Logos.toMIDI(event).flat;
				newEvent.do{|evt, i|
					if(newEvent[i][\midicmd]==\bend){
						newEvent[i][\val] = newEvent[i][\val].linlin(0, 16384, -1, 1);
					}
				};
				newEvent;
			} {
				[event]
			}
		}.flat;


		if(midiEvents==[]){
			"MIDIevents are []".warn;
			^Pseq([(\type: \midi, \midicmd: \ctl, \ctlNum: 123, \control: 127)]);
		}{
			^Pseq(midiEvents);
		};
	}

	// Core access methods
	*at {|key|
		^instrumentList[key] ?? {
			"Instrument % not found".format(key).warn;
			nil
		};
	}

	*keys { ^instrumentList.keys }
	*values { ^instrumentList.values }
	*do {|func| instrumentList.do(func) }
	*keysValuesDo {|func| instrumentList.keysValuesDo(func) }

	// Backward compatibility accessors (spec access only)
	*klung {^instrumentList.klung}
	*snar {^instrumentList.snar}
	*toypi {^instrumentList.toypi}
	*melauton {^instrumentList.melauton}
	*llor {^instrumentList.llor}
	*korn {^instrumentList.korn}
	*hunt {^instrumentList.hunt}
	*klar {^instrumentList.klar}
	*thunderwood {^instrumentList.thunderwood}
	*vacca {^instrumentList.vacca}
	*bug {^instrumentList.bug}
	*vibi {^instrumentList.vibi}
	*belly {^instrumentList.belly}
	*roro {^instrumentList.roro}
	*ob {^instrumentList.ob}
	*xy {^instrumentList.xy}
	*bomi {^instrumentList.bomi}
	*teno {^instrumentList.teno}
	*temblo {^instrumentList.temblo}
	*trump {^instrumentList.trump}
	*tubi {^instrumentList.tubi}
	*pos {^instrumentList.pos}
	*flex {^instrumentList.flex}
	*dripper {^instrumentList.dripper}
	*piperola {^instrumentList.piperola}
	*bourdonola {^instrumentList.bourdonola}
	*pi4 {^instrumentList.pi4}
	*harma {^instrumentList.harma}
	*psch {^instrumentList.psch}
	*puff {^instrumentList.puff}
	*bello {^instrumentList.bello}
	*pi3 {^instrumentList.pi3}
	*tubo {^instrumentList.tubo}
	*per {^instrumentList.per}
	*heli {^instrumentList.heli}
	*bono {^instrumentList.bono}
	*steely {^instrumentList.steely}
	*spiro {^instrumentList.spiro}
	*qt {^instrumentList.qt}
	*vitello {^instrumentList.vitello}
	*pi1 {^instrumentList.pi1}
	*qt2 {^instrumentList.qt2}
	*casta2 {^instrumentList.casta2}
	*troms {^instrumentList.troms}
	*sire {^instrumentList.sire}
	*asa {^instrumentList.asa}
	*hybrhi {^instrumentList.hybrhi}
	*hybrlo {^instrumentList.hybrlo}
	*tinti {^instrumentList.tinti}
	*springers {^instrumentList.springers}
	*fa {^instrumentList.fa}
	*hybr {^instrumentList.hybr}
	*so {^instrumentList.so}
	*krum {^instrumentList.krum}
	*aeio {^instrumentList.aeio}
	*rodo {^instrumentList.rodo}
	*horny {^instrumentList.horny}
	*autosax {^instrumentList.autosax}
	*pi2 {^instrumentList.pi2}
	*pp2 {^instrumentList.pp2}
	*chi {^instrumentList.chi}
	*voxhumanola {^instrumentList.voxhumanola}
	*flut {^instrumentList.flut}
	*kazumi {^instrumentList.kazumi}


	// Simple play method for instruments
	*play {|instrument, note=60, velocity=64, dur=1|
	var instrSpec = this.at(instrument);
	var midiout, chan;

	if(instrSpec.isNil) { ^nil };

	midiout = this.midiout(instrSpec.port);
	chan = instrSpec.chan;
	if(chan.isArray) { chan = chan[0] };

	midiout.noteOn(chan, note, velocity);

	if(dur.notNil) {
	SystemClock.sched(dur, {
	midiout.noteOff(chan, note, 0);
	});
	};

	// Return stop function
	^{ midiout.noteOff(chan, note, 0) };
	}


	// Control change method
	*cc {|instrument, ctlNum, value|
		var instrSpec = this.at(instrument);
		var midiout, chan;

		if(instrSpec.isNil) { ^nil };

		midiout = this.midiout(instrSpec.port);
		chan = instrSpec.chan;
		if(chan.isArray) { chan = chan[0] };

		midiout.control(chan, ctlNum, value);
	}

	// Generic methods that work for all instruments
	*listInstruments {
		"Available instruments:".postln;
		instrumentList.keysDo { |key|
			var spec = instrumentList[key];
			"  % - %".format(key, spec.name).postln;
		};
	}

	// MIDI output routing
	*midiout {|index, loc|
		var out, availableDestinations;
		var actualLocation = loc ?? location;

		// Get all available MIDI destinations
		availableDestinations = MIDIClient.destinations;

		if(actualLocation == \logos) {
			// Check if mioXL exists before creating MIDIOut objects
			var mioXLExists = availableDestinations.any { |dest|
				dest.device == "mioXL"
			};

			if(mioXLExists) {
				out = [
					MIDIOut.newByName("mioXL", "DIN 1"),
					MIDIOut.newByName("mioXL", "DIN 2"),
					MIDIOut.newByName("mioXL", "DIN 3"),
					MIDIOut.newByName("mioXL", "DIN 4"),
					MIDIOut.newByName("mioXL", "DIN 5"),
					MIDIOut.newByName("mioXL", "DIN 6"),
					MIDIOut.newByName("mioXL", "DIN 7"),
					MIDIOut.newByName("mioXL", "DIN 8"),
				];
			} {
				//"mioXL device not found! Using default MIDIOut ports.".warn;
				out = 8.collect{|i| MIDIOut(i)};
			};
		} {
			out = 8.collect{|i| MIDIOut(i)};
		};

		// Bounds checking
		if(index < out.size && {index>=0}) {
			^out[index];
		} {
			"MIDIOut % does not exist! Sending to MIDIOut(0).".format(index).warn;
			^MIDIOut(0);
		};
	}

	// Power control utility
	*power{|instrument, value=\on|
		var instrSpec = instrumentList.at(instrument);
		var ctlNum, finalValue;

		if(instrSpec.isNil) {
			"Instrument % not found".format(instrument).warn;
			^nil;
		};

		// Check if power property exists
		if(instrSpec.power.isNil) {
			"Instrument % has no power control".format(instrument).warn;
			^nil;
		};

		ctlNum = instrSpec.power.ctlNum;

		// Simple logic with explicit checks
		if(value == \on) {
			finalValue = 127;
		} {
			if(value == \off) {
				finalValue = 0;
			} {
				if(value.isKindOf(Number)) {
					finalValue = value.asInteger;
				} {
					"Unknown power value: %, using default 127".format(value).warn;
					finalValue = 127;
				};
			};
		};

		Logos.cc(instrument, ctlNum, finalValue);

	}

	*allOff {
		MIDIClient.destinations.size.do{|i|
			16.do{|j|
				MIDIOut(i).control(j, 66, 0);
				MIDIOut(i).control(j, 65, 0);
			};
		}
	}

	// Wind control utility - CORRECTED
	*wind{|instrument, value=127|
		var instrSpec = instrumentList.at(instrument);
		var ctlNum, finalValue;

		if(instrSpec.isNil) {
			"Instrument % not found".format(instrument).warn;
			^nil;
		};

		// Fixed: Proper nil checking for nested properties
		if(instrSpec.dynamics.isNil) {
			"Instrument % has no dynamics property".format(instrument).warn;
			^nil;
		};

		if(instrSpec.dynamics.wind.isNil) {
			"Instrument % has no wind control".format(instrument).warn;
			^nil;
		};

		ctlNum = instrSpec.dynamics.wind.ctlNum;

		// Simple logic with explicit checks
		if(value.isKindOf(Number)) {
			finalValue = value.asInteger;
		} {
			"Unknown wind value: %, using default 127".format(value).warn;
			finalValue = 127;
		};

		Logos.cc(instrument, ctlNum, finalValue);
	}

	*subgroup {|subgroup|
		var selection = [];

		Logos.keysValuesDo{|instrument|
			if(Logos.at(instrument).subgroup == subgroup){
				selection = selection ++ instrument;
			}
		};
		^selection;
	}

	*panic {|instrument|
		var panicType;

		if(Logos.at(instrument).isNil){
			^Logos.panicAll;
		};

		if(Logos.at(instrument).panic == true){
			// if panic implemented:
			panicType = \control;
			Logos.at(instrument).chan.asArray.do{|chan|
				Logos.midiout(Logos.at(instrument).port).control(chan, 123, 127);
			}
		}{
			// if no panic implemented:
			panicType = \note;
			128.do{|note|
				Logos.at(instrument).chan.asArray.do{|chan|
					Logos.midiout(Logos.at(instrument).port).noteOff(chan, note, 0);
				}
			};

		};

		^"sent % panic (%)".format(instrument, panicType);
	}

	*panicAll {
		Logos.keys.do{|instrument|
			Logos.panic(instrument);
		};
	}

	*sort {|instruments, sortBy=\first|
		var borderNotes;

		borderNotes = instruments.collect{|instrument, i|
			switch(sortBy,
				\first, {
					Logos.at(instrument).range.default[0];
				},
				\last, {
					Logos.at(instrument).range.default.last;
				}
			)

		};

		^borderNotes.order.collect{|i|
			instruments[i].postln;
		};
	}

}

/*
Usage Examples - Simple and Working:

// Direct class methods (these work perfectly):
Logos.power(\qt, \off);              // Turn off qt
Logos.power(\qt, \on);               // Turn on qt
Logos.power(\qt, 64);                // Set qt power to 64
Logos.cc(\qt, 7, 100);              // Set qt wind to 100
Logos.play(\qt, 60, 100, 2.0);      // Play qt note

// Spec access (works great):
Logos.qt.dynamics.wind;              // Get wind spec
Logos.qt.range.default;              // Get note range
Logos.at(\qt).powerSpec.ctlNum;      // Get power CC number

// Pattern usage:
Pbind(
\type, \logos,
\instrument, \qt,
\midinote, Pseq([60, 62, 64, 65], inf),
\dur, 0.25,
\wind, 100
).play;

// For MIDI file processing:
b = a.asStream;
rawEvent = b.next(());
midiEvents = Logos.toMIDI(rawEvent);  // Get MIDI events without playing
*/