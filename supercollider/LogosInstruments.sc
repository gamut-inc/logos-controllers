// LogosInstruments.sc - Instrument Specifications
// Save this file separately from Logos.sc

LogosInstruments {

	*instrumentSpecs {
		^(

			// organs:
			\voxhumanola: (
				\name: "Vox Humanola",
				\type: \organ,
				\instrumentGroup: \organ,
				\subgroup: \acoustic,
				\port: 0,
				\chan: 1,
				\power: (\ctlNum: 66),
				\panic: true,
				\range: (\default: (36..91), \castagnettes: (113..127), \horn: [31]),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 89, \obligatory: true))
			),

			\qt: (
				\name: "Qt",
				\type: "quartertone organ",
				\instrumentGroup: \organ,
				\subgroup: \acoustic,
				\port: 1,
				\chan: [5, 6],
				\power: (\ctlNum: 66),
				\range: (\default: (36..108)),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 102),
					\adsr: (
						\a: (\ctl: \velocity)
					),
					\tremolo: (\speed: (\low: (\ctlNum: 11), \high: (\ctlNum: 12))),
					\afterTouch: (\ctlNum: 69),
				),

				\tuning: (
					\microtuning:
					(
						\ctl: \chan,
					)
				),
			), //end Qt
			\qt2: (
				\name: "Qt2",
				\type: "quartertone organ",
				\instrumentGroup: \organ,
				\subgroup: \acoustic,
				\port: 1,
				\chan: 6, // 6 for quarternotes
				\power: (\ctlNum: 66),
				\range: (\default: (36..108)),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 102),
					\adsr: (
						\a: (\ctl: \velocity)
					),
					\tremolo: (\speed: (\low: (\ctlNum: 11), \high: (\ctlNum: 12))),
					\afterTouch: (\ctlNum: 69),
				),

				\tuning: (
					\microtuning:
					(
						\ctl: \chan,
					)
				),
			), //end Qt


			\bourdonola: (
				\name: "Bourdonola",
				\type: "organ",
				\instrumentGroup: \organ,
				\subgroup: \acoustic,
				\port: 0,
				\chan: 2,
				\power: (\ctlNum: 66),
				\range: (\default: (36..72)),

				\dynamics: (
					\wind: (\ctlNum: 1, \default: 102),
				)
			),

			\harma: (
				\name: "Harma",
				\type: \organ,
				\instrumentGroup: \organ,
				\subgroup: \acoustic,
				\port: 0,
				\chan: 9,
				\power: (\ctlNum: 66),
				\range: (\default: (29..89)),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 60, \range: [20, 100]),
				)
			),

			\krum: (
				\name: "Krum",
				\type: \organ,
				\instrumentGroup: \organ,
				\subgroup: \acoustic,
				\port: 2,
				\chan: 7,
				\power: (\ctlNum: 66),
				\range: (\default: (36..91)),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 111, \obligatory: true),
				)
			),

			\piperola: (
				\name: "Piperola",
				\type: "organ",
				\instrumentGroup: \organ,
				\subgroup: \oneshot,
				\port: 6,
				\chan: 2,
				\power: (\ctlNum: 65), // !!!
				\range: (\default: (60..108)),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 85),
				)
			),

			\trump: (
				\name: "Trump",
				\type: "organ",
				\instrumentGroup: \organ,
				\subgroup: \acoustic,
				\port: 0,
				\chan: 15,
				\power: (\ctlNum: 66),
				\range: (\default: (32..68)),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 100, \obligatory: true)
				)
			),

			\puff: (
				\name: "Puff",
				\instrument: \organ,
				\instrumentGroup: \organ,
				\subgroup: \oneshot,
				\port: 5,
				\chan: 13,
				\power: (\ctlNum: 66),
				\dynamics: (),
				\range: (\default: (55..96), \quarterTones: (7..49)),
				\tuning: (
					\microtuning: (
						\ctl: \range,
					)
				)
			),

			\bomi: (
				\name: "Bomi",
				\instrument: \organ,
				\instrumentGroup: \organ,
				\subgroup: \acoustic,
				\port: 3,
				\chan: 3,
				\power: (\ctlNum: 66),
				\range: (\default: (55..91)),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 72),
					\valve: (\ctlNum: 1),
				),
			),

			\hybr:(
				\name: "Hybr",
				\type: "hybrid organ",
				\instrumentGroup: \organ,
				\subgroup: \hybrid,
				\port: 4,
				\chan: 8,
				\power: (\ctlNum: 66),
				\panic: true,
				\range: (\default: (33..72)),

				\dynamics: (
					\wind: (\ctlNum: 7),
					\adsr: (
						\a: (\ctlNum: 16, \default: 1, \amp: (\ctlNum: 17, \default: 127)),
						\d: (\ctlNum: 18, \default: 1),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19, \default: 1),
					),
					\tremolo: (\depth: (\ctlNum: 5), \speed: (\ctlNum:6)),
				),
				\tuning: (
					\global: (\ctlNum: 20),
					\microtuning:
					(
						\ctl: \polyTouch,
						\range: 1/2,
						\on: (
							\ctlNum: 124,
							\default: 64,
						),
					),
					\vibrato: (\depth: (\ctlNum: 3), \speed: (\ctlNum:4)),
				),
				\sound: (
					\noise: (\ctlNum: 1),
					\wave: (\ctlNum: 13, \default: 0, \range: [0, 1, 2]),
				)


			),

			\hybrhi:(
				\name: "HybrHi",
				\type: "hybrid organ",
				\instrumentGroup: \organ,
				\subgroup: \hybrid,
				\port: 4,
				\chan: 8,
				\power: (\ctlNum: 66),
				\range: (\default: (73..108)),
				\panic: true,

				\dynamics: (
					\wind: (\ctlNum: 7),
					\adsr: (
						\a: (\ctlNum: 16, \default: 1, \amp: (\ctlNum: 17, \default: 127)),
						\d: (\ctlNum: 18, \default: 1),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19, \default: 1),
					),
					\tremolo: (\depth: (\ctlNum:5), \speed: (\ctlNum: 6)),
				),
				\tuning: (
					\global: (\ctlNum: 20, \range: 1/2),
					\microtuning:
					(
						\ctl: \polyTouch,
						\range: 1/2,
						\on: (
							\ctlNum: 124,
							\default: 64,
						),
					),
					\vibrato: (\depth: (\ctlNum: 3), \speed: (\ctlNum: 4)),
				),
				\sound: (
					\noise: (\ctlNum: 1)
				)
			),

			\hybrlo: (
				\name: "HybrLo",
				\type: "hybrid organ",
				\instrumentGroup: \organ,
				\subgroup: \hybrid,
				\port: 7,
				\chan: 8,
				\power: (\ctlNum: 66),
				\range: (\default: (22..69)),
				\panic: true,

				\dynamics: (
					\volume: (\ctlNum: 7), // ctl 94-105 can change sustain of notes 22-33 during playing individually // applies to all octaves of pitch
					\scaling: (\ctlNum: 80, \default: 32, \db: 30),
					\adsr: (
						\a: (\ctlNum: 16, \amp: (\ctl: \velocity)),
						\d: (\ctlNum: 17),

						\r: (\ctlNum: 19),
					),
				),
				\sound: (
					\noise: (\ctlNum: 1),
					\wave: (\ctlNum: 14),
				)

				/*controller 20: Tuning [default 64 for A=440Hz], (not implemented yet)
				Keypressure implemented for wave-shaping (notes 22 - 69)
				Channel Aftertouch implemented for global amplitude modulation."*/
			),

			\melauton: (
				\name: "Melauton",
				\type: \melodica,
				\instrumentGroup: \organ,
				\subgroup: \acoustic,
				\port: 10,
				\chan: 1,
				\power: (\ctlNum: 66),
				\panic: true,
				\range: (\default: (60..84)),

				\dynamics: (
					\velocity: false,
					\wind: (\ctlNum: 7),
				)

				/*
				Controller 68: Motor mode of operation [default = 1, advised:9]
				Controller 69: minimum motor speed [default = 80]
				Controller 70: Scaling factor for wind control [default = 64]
				Controller 71: wait time before standby wind pressure (in 0.1 s units)
				Controller 72: wait time before motor off (in 0.1 s units)*/
			),

			\pos: (
				\name: "Pos",
				\type: \organ,
				\instrumentGroup: \organ,
				\subgroup: \acoustic,
				\port: 1,
				\chan: 2,
				\power: (\ctlNum: 66),
				\panic: true,
				\range: (\default: (36..100), \wood: (36..48), \tin_closed: (49..94), \tin_open: (95..100)),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 127),
					\adsr: (
						\a: (\ctl: \velocity),
					),
				),
				\sound: (
					\repetition: (\ctl: \polyTouch, \globalSpeed: 30),
				)

			),

			\pi1: (
				\name: "Pi",
				\instrument: \organ,
				\instrumentGroup: \organ,
				\subgroup: \hybrid,
				\port: 2,
				\chan: 5,
				\power: (\ctlNum: 66),
				\panic: true,
				\range: (\default: (84..127), \lights: [1, 2]),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 96),
					\adsr: (
						\a: (\ctlNum: 17, \default: 8, \amp: (\ctl: \velocity)),
						\d: (\ctlNum: 18, \default: 6),
						\s: (\ctlNum: 7),
						\r: (\ctlNum: 19, \default: 10)
					),
				),
				\tuning: (
					\global: (\ctlNum: 21), // 12-23 just intonation on c-b
					\microtuning: (\ctlNum: (72..115), \ctl: \seq),
				),
				\sound: (
					\noise: (\ctlNum: 1, \default: 0),
					\wave: (\ctlNum: 25, \default: 127)
				)
			),

			\pi2: (
				\name: "2Pi",
				\instrument: \organ,
				\instrumentGroup: \organ,
				subgroup: \hybrid,
				\port: 3,
				\chan: 5,
				\power: (\ctlNum: 66),
				\panic: true,
				\range: (\default: (72..101), \lights: [1, 2]),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 96),
					\adsr: (
						\a: (\ctlNum: 17, \default: 8, \amp: (\ctl: \velocity)),
						\d: (\ctlNum: 18, \default: 6),
						\s: (\ctlNum: 7),
						\r: (\ctlNum: 19, \default: 10)
					),
				),
				\tuning: (
					\global: (\ctlNum: 21), // 12-23 just intonation on c-b
					\microtuning: (\ctlNum: (72..101), \ctl: \seq),
				),
				\sound: (
					\noise: (\ctlNum: 1, \default: 0),
					\wave: (\ctlNum: 15, \default: 127),
				),
			),

			\pi3: (
				\name: "3Pi",
				\type: \organ,
				\instrumentGroup: \organ,
				\subgroup: \hybrid,
				\port: 4,
				\chan: 6,
				\power: (\ctlNum: 66),
				\panic: true,
				\range: (\default: (60..89), \lights: [1, 2]),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 127),
					\adsr: (
						\a: (\ctlNum: 17, \default: 10, \amp: (\ctl: \velocity)),
						\d: (\ctlNum: 18, \default: 20),
						\s: (\ctlNum: 16, \default: 118),
						\r: (\ctlNum: 19, \default: 10)
					),
				),
				\tuning: (
					\global: (\ctlNum: 21), // 12-23 just intonation on c-b
					\microtuning: (\ctlNum: (72..101), \ctl: \seq),
				),
				\sound: (
					\noise: (\ctlNum: 1, \default: 0),
					\wave: (\ctlNum: 15, \default: 99),
				)

			),

			\pi4: (
				\name: "4Pi",
				\type: \organ,
				\instrumentGroup: \organ,
				\subgroup: \hybrid,
				\port: 2,
				\chan: 11,
				\power: (\ctlNum: 66),
				\panic: true,
				\range: (\default: (60..89), \lights: (12..14)),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 127),
					\adsr: (
						\a: (\ctlNum: 17, \default: 10, \amp: (\ctl: \velocity)),
						\d: (\ctlNum: 18, \default: 20),
						\s: (\ctlNum: 16, \default: 84),
						\r: (\ctlNum: 19, \default: 10)
					),
				),
				\tuning: (
					\global: (\ctlNum: 21), // values 12-23 sets to just intonation on c-b
					\microtuning: (\ctlNum: (72..101), \ctl: \seq),
				),
				\sound: (
					\noise: (\ctlNum: 1, \default: 8),
					\wave: (\ctlNum: 15, \default: 99),
				)

			),

			\roro: (
				\name: "RorO",
				\type: \organ,
				\instrumentGroup: \organ,
				\subgroup: \acoustic,
				\port: 7,
				\chan: 3,
				\power: (\ctlNum: 66),
				\panic: true,

				\range: (
					\gedackt: (36..75),
					\gedackt_salicional: (76..83),
					\flute_salicional: (84..93),
					\salicional: (94..115),
				),

				\lights: (
					\automation: (\ctlNum: 69, \default: 0)
				),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 43),
					\adsr:(
						\a: (\ctlNum: \velocity)
					),
					\tremolo: (\speed: (\ctlNum: 11))
				),
				\sound: (
					\repetitions: (\ctl: \polyTouch, \global: (\ctlNum: 30)),
					\registers: (\pc: [3, 7, 11, 19, 35], \default: 7),
				)
			),

			// Wood & Brass:

			\autosax: (
				\name: "Autosax",
				\type: \tenorSax,
				\instrumentGroup: \wind,
				\subgroup: \wood,
				\port: 2,
				\chan: 3,
				\power: (\ctlNum: 66),
				\range: (\default: (24..90), \lights: (121..127)),

				\dynamics: (
					\wind: (\ctlNum: 7, \noise: 1, \default: 100),
					\velocity: \sustain,
					\adsr: (
						\a: (\ctlNum: 16, \amp: (\ctlNum: 17)),
						\d: (\ctlNum: 18),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19),
						\period: (\ctlNum: 15),
					),
					\tremolo: (\speed: (\ctlNum: 5), \depth: (\ctlNum: 6)),
					\scaling: (\ctlNum: 80)
				),
				\tuning: (
					\microtuning: (
						\ctl: \pitchBend,
						\range: 1/2, // in halfsteps !!!
					),
					\vibrato: (\speed: (\ctlNum: 3), \depth: (\ctlNum: 4)),
					\global: (\ctlNum: 20, \default: 64, \freq: 440), // = A=440Hz
				),
				\sound: (
					\fingering: (\ctl: \polyTouch)
				),
			),


			\so: (
				\name: "So",
				\type: \sousaphone,
				\instrumentGroup: \wind,
				\subgroup: \brass,
				\port: 0,
				\chan: 14,
				\power: (\ctlNum: 66),
				\range: (\default: (15..69)),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 100),
					\velocity: true,
					\adsr: (
						\a: (\ctlNum: 16, \default: 45, \amp: (\ctlNum: 17, \default: 100)),
						\d: (\ctlNum: 18, \default: 100),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19, \default: 90),
						\period: (\ctlNum: 15, \default: 20),
					),
					\tremolo: (\speed: (\ctlNum: 5), \depth: (\ctlNum: 6)),
					\scaling: (\ctlNum: 80, \default: 32)
				),
				\tuning: (
					\microtuning: (
						\ctl: \pitchBend,
						\range: 1/2, // in halfsteps !!!
					),
					\vibrato: (\speed: (\ctlNum: 3), \depth: (\ctlNum: 4)),
					\tuning: (\ctlNum: 20, \default: 64, \freq: 440)
				),
				\sound: (
					\fingerings: 13,
					\display: (\ctlNum: [34, 37]),
					\noise: (\ctlNum: 1)
				)
			),

			\bono: (
				\name: "Bono",
				\type: \trombone,
				\instrumentGroup: \wind,
				\subgroup: \brass,
				\port: 6,
				\chan: 13,
				\power: (\ctlNum: 66),
				\range: (\default: (34..79), \extended: (0..33)++(80..96), \lights: (120..125)),
				\position: (
					\vertical: (\ctlNum: 22),
					\horizontal: (\ctlNum: 10),
				),

				\dynamics: (
					\wind: (\ctlNum: 7),
					\adsr: (
						\a: (\ctlNum: 18, \default: 100, \amp: (\ctlNum: 17, \default: 127)),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19)
					),
				),

				\tuning: (
					\microtuning: (
						\ctl: \pitchBend,
						\range: 1/2, // in halfsteps !!!
					),
					\tuning: (\ctlNum: 20, \default: 0) // A = 440Hz
				),
				\sound: (
					fingerings: (\ctlNum: 13, \tables: (\ctl: \pc, \default: 0))
				)
			),

			\korn: (
				\name: "Korn",
				\type: \cornet,
				\instrumentGroup: \wind,
				\subgroup: \brass,
				\port: 1,
				\chan: 12,
				\power: (\ctlNum: 66),
				\range: (\default: (66..89), \extended: (54..65)++(89..94)),

				\dynamics: (
					\wind: (\ctlNum: 17, \default: 86),
					\adsr: (
						\a: (\ctlNum: 18, \default: 105, \amp: (\ctlNum: 17, \default: 90)),
						\s: (\ctl: \velocity),
					),
				),
				\tuning: (
					\microtuning: (
						\ctl: \pitchBend,
						\range: 1/2,
					),
					\tuning: (\ctlNum: 20, \default: 0, \freq: 440)
				),
				\sound: (
					\valve: (\ctlNum: 25, \default: 40),
					\fingerings: (\ctlNum: 13),
				),
			),

			\ob:(
				\name: "Ob",
				\type: \oboe,
				\instrumentGroup: \wind,
				\subgroup: \wood,
				\port: 6,
				\chan: 14,
				\power: (\ctlNum: 66),
				\range: (\default: (58..96), \lights: (0..5)), // light velo = flesh frequency
				\position: (
					\vertical: (\ctlNum: 22, \default: 64),
				),

				\dynamics: (
					\wind: (ctlNum: 17),
					\adsr: (
						\a: (\ctlNum: 18, \amp: (\ctlNum: 17, \default: 72)),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19),
					),
				),
				\tuning: (
					\microtuning: (
						\ctl: \pitchBend,
						\range: 1/2),
					\global: (\ctlNum: 20, \default: 5) // A = 440Hz
				),
				\sound: (
					\fingerings: (\ctl: \polyTouch),
				)

			), // end oboe


			\heli:  (
				\name: "Heli",
				\type: \helicon,
				\instrumentGroup: \wind,
				\subgroup: \brass,
				\port: 6,
				\chan: 8,
				\power: (\ctlNum: 66),
				\range: (\default: (22..91)),

				\dynamics: (
					\wind: (\ctlNum: 17, \default: 127), // in fact this is attack amp !!!
					\velocity: \sfz,
					\adsr: (
						\a: (\ctlNum: 18, \default: 125, \amp: (\ctlNum: 17)),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19, \default: 96),
					),
				),
				\tuning: (
					\microtuning: (
						\ctl: \pitchBend,
						\range: 1/2,
					),
					\global: (ctl: 20, \default: 0, \freq: 440),
				),
				\sound: (
					\noise: (\ctlNum: 1),
					\color: (\ctlNum: 7, \default: 64),
					\fingerings: (\ctlNum: \unknown),
					\externalAudio: (\ctlNum: 8)
				)

			), // end Heli

			\fa: (
				\name: "Fa",
				\type: \bassoon,
				\instrumentGroup: \wind,
				\subgroup: \wood,
				\port: 4,
				\chan: 15,
				\power: (\ctlNum: 66),
				\panic: true,
				\range: (\default: (34..91)),
				\position: (
					\vertical: (\ctlNum: 22, \default: 10),
				),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 64),
					\velocity: \sfz,
					\tremolo: (\depth: (\ctlNum: 5), \speed: (\ctlNum: 6), \delay: (\ctlNum: 44)),
					\adsr: (
						\a: (\ctlNum: 16, \default: 80, \amp: (\ctlNum: 17, \default: 127),
						),
						\d: (\ctlNum: 18, \default: 64),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19, \default: 72),

					),
				),
				\tuning: (
					\microtuning: (\ctl: \pitchBend, \range: 1/2),
					\vibrato: (\depth: (\ctlNum: 3), \speed: (\ctlNum: 4), \delay: (\ctlNum: 43), \fingered: (\ctlNum: 31, \default: 10)),
					\global: (\ctlNum: 20, \default: 64, \freq: 440),
				),
				\sound: (
					\noise: (\ctlNum: 1, \default: 2),
					\fingerings: (\ctlNum: (100..103)),
					\valve: (\ctlNum: 30),
					\filter: (
						\lfo: (
							\frequency: (\ctlNum: 2),
							\depth: (\ctlNum: 29, \default: 21)
						),
						\frequency: (\ctlNum: 25, \default: 75),
						\q: (\ctlNum: 26, \default: 100)
					),
					\echo: (
						\mix: (\ctlNum: 27, \default: 0),
						\feedback: (\ctlNum: 28, \default: 0)
					),
				)

			), // end Fa

			\klar: (
				\name: "Klar",
				\type: \clarinet,
				\instrumentGroup: \wind,
				\subgroup: \wood,
				\port: 5,
				\chan: 5,
				\power: (\ctlNum: 66),
				\range: (\default: (43..91), \extended: (92..106)),

				\position: (
					\vertical: (\ctlNum: 22, \default: 64),
				),

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 64),

					\tremolo: (\depth: (\ctlNum: 5), \speed: (\ctlNum: 6), \delay: (\ctlNum: 44)),
					\adsr: (
						\a: (\ctlNum: 16, \default: 80, \amp: (\ctlNum: 17, \default: 127)),
						\d: (\ctlNum: 18, \default: 64),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19, \default: 72),
					),
				),
				\tuning: (
					\microtuning: (\ctl: \pitchBend, \range: 1/2),
					\global: (\ctlNum: 20, \default: 64, \freq: 440),
					\vibrato: (
						\depth: (\ctlNum: 3), \speed: (\ctlNum: 4), \delay: (\ctlNum: 43),
						\fingered: (\ctlNum: 31, \default: 0), /*channel aftertouch implemented for fingered vibrato*/
					),
					\duodezime: (\detune: (\ctlNum: 41, \default: 62), \amp: (\ctlNum: 42)),
				),
				\sound: (
					\noise: (\ctlNum: 1, \default: 2),
					\fingerings: (\ctlNum: (100..103)),
					\valve: (\ctlNum: 30),
					\filter: (
						\lfo: (
							\frequency: (\ctlNum: 2, \default: 2),
							\depth: (\ctlNum: 29, \default: 21)
						),
						\frequency: (\ctlNum: 25, \default: 62),
						\q: (\ctlNum: 26, \default: 90)
					),
					\echo: (
						\mix: (\ctlNum: 27, \default: 0),
						\feedback: (\ctlNum: 28, \default: 0)
					),
				)

			), // end klar

			\horny: (
				\name: "Horny",
				\type: \horn,
				\instrumentGroup: \wind,
				\subgroup: \brass,
				\port: 5,
				\chan: 14,
				\power: (\ctlNum: 66),

				\range: (
					\pedals: (23..29),
					\unplayable: (30..34),
					\default: (35..84),
					\high: (85..94),
					\lights: (127..127),
				),

				\dynamics: (
					\wind: (\ctlNum: 7),
					\tremolo: (\depth: (\ctlNum: 5), \speed: (\ctlNum: 6), \delay: (\ctlNum: 44)),
					\adsr: (
						\a: (\ctlNum: 16, \amp: (\ctlNum: 17)),
						\d: (\ctlNum: 18),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19)
					),
				),

				\tuning: (
					\vibrato: (\depth: (\ctlNum: 3), \speed: (\ctlNum: 4), \delay: (\ctlNum: 43)),
					\global: (\ctlNum: 20, \default: 64, \freq: 440),
					\f_or_Bb_Horn: (\ctlNum: 33),
					\microtuning: (\ctl: \pitchBend, \range: 1/2),
				),

				\sound: (
					\noise: (\ctlNum: 1),
					\valve: (\ctlNum: 30),
					\filter: (
						\freq: (\ctlNum: 25, \default: 62, \advised: 49),
						\resonance: (\ctlNum: 26, \default: 90, \advised: 120),
						\lfo: (\ctlNum: 2, \advised: 2),
						\depth: (\ctlNum: 29, \default: 20, \advised: 20),
					),
					\echo: (
						\mix: (\ctlNum: 27, \default: 0, \advised: 2),
						\feedback: (\ctlNum: 28, \default: 0)
					),
				),

				\position: (
					\ctlNum: 22,
					\default: 64,
				),

			), // end Horny

			\asa: (
				\name: "Asa",
				\type: \saxophone,
				\instrumentGroup: \wind,
				\subgroup: \wood,
				\port: 1,
				\chan: 3,
				\power: (\ctlNum: 66),

				\range: (
					\default: (49..80),
					\high: (81..96),
					\lights: (120..126),
				),

				\dynamics: (
					\wind: (\ctlNum: 7),
					\tremolo: (\depth: (\ctlNum: 5), \speed: (\ctlNum: 6), \delay: (\ctlNum: 44)),
					\adsr: (
						\a: (\ctlNum: 16, \amp: (\ctlNum: 17)),
						\d: (\ctlNum: 18),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19)
					),
				),

				\tuning: (
					\global: (\ctlNum: 20, \default: 64, \freq: 440, \range: 1/2),
					\microtuning: (\ctl: \pitchBend, \range: 1/2),
					\vibrato: (\depth: (\ctlNum: 3), \speed: (\ctlNum: 4), \delay: (\ctlNum: 43)),
				),

				\sound: (
					\noise: (\ctlNum: 1),
					\valve: (\ctlNum: 30),
					\filter: (
						\freq: (\ctlNum: 25, \default: 62, \advised: 100),
						\resonance: (\ctlNum: 26, \default: 90, \advised: 81),
						\lfo: (\ctlNum: 2, \default: 2, \advised: 1),
						\depth: (\ctlNum: 29, \default: 20, \advised: 10),
					),
					\echo: (
						\mix: (\ctlNum: 27, \default: 0, \advised: 2),
						\feedback: (\ctlNum: 28, \default: 0)
					),
				),
				\position: (
					\vertical: (\ctlNum: 22),
					\horizontal: (\ctlNum: 23)
				),

			), // end Asa

			\bug: (
				\name: "Bug",
				\type: \flugelhorn,
				\instrumentGroup: \wind,
				\subgroup: \brass,
				\port: 2,
				\chan: 12,
				\power: (\ctlNum: 66),
				\panic: true,

				\range: (
					\default: (52..94),
					\lights: (121..127),
				),

				\dynamics: (
					\wind: (\ctlNum: 7),
					\tremolo: (\depth: (\ctlNum: 5), \speed: (\ctlNum: 6)),
					\adsr: (
						\a: (\ctlNum: 16, \amp: (\ctlNum: 17)),
						\d: (\ctlNum: 18),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19),
						\period: (\ctlNum: 15),
					),
				),

				\tuning: (
					\global: (
						\ctlNum: 20,
						\default: 64,
						\freq: 440,
						(48..59): \just1, // just intonation based on corresponding fundamentals - scale:  1:1, 16:15, 9:8, 6:5, 5:4, 4:3, 10:7, 3:2, 8:5, 5:3, 16:9, 15:8, 2:1
						61: \qt_down,
						62: 435,
						63: 438,
						65: 442,
						66: 445,
						67: \qt_up,
						(72..83): \just2, // just intonation based on corresponding fundamentals - scale:  1:1, 21:20, 9:8, 7:6, 5:4, 4:3, 7:5, 3:2, 14:9, 5:3, 7:4, 15:8, 2:1
					),
					\microtuning: (\ctl: \pitchBend, \range: 1/2),
					\vibrato: (\depth: (\ctlNum: 3), \speed: (\ctlNum: 4)),
				),

				\sound: (
					\noise: (\ctlNum: 1),
					\valve: (\force: (\ctlNum: 25, \default: 64), \release: (\ctlNum: 26)),
					\fingerings: (\ctlNum: 13),
					\wave: (\form: (\pc: (0..11)), \shape: (\ctlNum: (101..110))), // details in manual
				),

				\position: (
					\horizontal: (\ctlNum: 10, \speed: (\ctlNum: 31)),
					\vertical: (\ctlNum: 11, \speed: (\ctlNum: 33)),
				),

			), // end Bug

			\flut: (
				\name: "Flut",
				\type: \flute,
				\instrumentGroup: \wind,
				\subgroup: \wood,
				\port: 1,
				\chan: 13,
				\power: (\ctlNum: 66),
				\panic: true,

				\range: (
					\extended: (48..59)++(97..105),
					\default: (60..96),
					\lights: (\blue: (\ctlNum: [120, 121]), \center: (\ctlNum: 122), \eye: (\ctlNum: [123, 124])),
				),

				\lights: (\ctlNum: 69), // automode

				\dynamics: (
					\wind: (\ctlNum: 7),
					\tremolo: (\depth: (\ctlNum: 5), \speed: (\ctlNum: 6)),
					\adsr: (
						\a: (\ctlNum: 16, \amp: (\ctlNum: 17)),
						\d: (\ctlNum: 18),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19),
						\period: (\ctlNum: 15),
					),
				),

				\tuning: (
					\global: (
						\ctlNum: 20,
						\default: 64,
						\freq: 440,
						//41: \overtoneMode,
						//(48..59): \just1, // just intonation based on corresponding fundamentals - scale:  1:1, 16:15, 9:8, 6:5, 5:4, 4:3, 10:7, 3:2, 8:5, 5:3, 16:9, 15:8, 2:1
						61: \qt_down,
						62: 435,
						63: 438,
						65: 442,
						66: 445,
						67: \qt_up,
						//(72..83): \just2, // just intonation based on corresponding fundamentals - scale:  1:1, 21:20, 9:8, 7:6, 5:4, 4:3, 7:5, 3:2, 14:9, 5:3, 7:4, 15:8, 2:1
					),
					//\qt: (\down: (\ctl: 61), \up: (\ctl: 67)),
					//\transpose: (\ctl: [62, 63, 65, 66], \freq: [435, 438, 442, 445]),
					\microtuning: (
						\ctl: \pitchBend,
						\range: 1/2 // in halfsteps !!!
					),
					\vibrato: (\depth: (\ctlNum: 3), \speed: (\ctlNum: 4)),
				),

				\sound: (
					\noise: (\ctlNum: 1),
					\lip: (\ctlNum: 2),
					\valve: (\force: (\ctlNum: 25, \default: 40), \release: (\ctlNum: 26)),
					\fingerings: (\ctlNum: 13),
					\wave: (\form: (\pc: (0..11)), \shape: (\ctlNum: (101..110))), // details in manual
				),

			), // end flut

			\hunt: (
				\name: "Hunt",
				\type: "hunting horn",
				\instrumentGroup: \wind,
				\subgroup: \brass,
				\port: 7,
				\chan: 2,
				\power: (\ctlNum: 66),

				\range: (
					\default: (41..91),
					\gunshot: [107],
					\lights: (\ctlNum: (121..127)),
				),

				\dynamics: (
					\wind: (\ctlNum: 7),
					\range: (\ctlNum: 80, \default: 32),
					\tremolo: (\depth: (\ctlNum: 5), \speed: (\ctlNum: 6)),
					\adsr: (
						\a: (\ctlNum: 16, \amp: (\ctlNum: 17)),
						\d: (\ctlNum: 18),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19),
						\period: (\ctlNum: 15),
					),
				),

				\tuning: (
					\global: (
						\ctlNum: 20,
						\default: 64,
						\freq: 440,
						41: \overtoneMode,
						(48..59): \just1, // just intonation based on corresponding fundamentals - scale:  1:1, 16:15, 9:8, 6:5, 5:4, 4:3, 10:7, 3:2, 8:5, 5:3, 16:9, 15:8, 2:1
						61: \qt_down,
						62: 435,
						63: 438,
						65: 442,
						66: 445,
						67: \qt_up,
						(72..83): \just2, // just intonation based on corresponding fundamentals - scale:  1:1, 21:20, 9:8, 7:6, 5:4, 4:3, 7:5, 3:2, 14:9, 5:3, 7:4, 15:8, 2:1
					),
					\microtuning: (\ctl: \pitchBend, \range: 1/2),
					\vibrato: (\depth: (\ctlNum: 3), \speed: (\ctlNum: 4)),
				),

				\sound: (
					\noise: (\ctlNum: 1),
					\valve: (\force: (\ctlNum: 25, \default: 40), \release: (\ctlNum: 26)),
					\wave: (\form: (\pc: (0..11)), \shape: (\ctlNum: (101..110))), // details in manual
				),

				\position: (
					\vertical: (\ctlNum: 22, \default: 63),
				)

			), // end hunt

			\teno: (
				\name: "Teno",
				\type: "Tenor Saxhorn",
				\instrumentGroup: \wind,
				\subgroup: \brass,
				\port: 4,
				\chan: 13,
				\power: (\ctlNum: 66),
				\panic: true,

				\range: (
					\default: (46..82),
					\low: [28, 34, 40],
					\high: (83..89),
					\lights: (120..121),
				),

				\dynamics: (
					\wind: (\ctlNum: 7),
					\range: (\ctlNum: 80, \default: 62),
					\tremolo: (\depth: (\ctlNum: 5, \default: 4), \speed: (\ctlNum: 6, \default: 20)),
					\adsr: (
						\a: (\ctlNum: 16, \default: 30, \amp: (\ctl: \velocity)),
						\d: (\ctlNum: 18, \default: 8),
						\s: (\ctl: 17), // 127 = 100& of attack -> no decay
						\r: (\ctlNum: 19, \default: 120),
						\period: (\ctlNum: 15, \default: 40),
					),
				),

				\tuning: (
					\global: (
						\ctlNum: 20,
						\default: 64,
					),
					\microtuning: (\ctl: \pitchBend, \range: 1/2),
					\vibrato: (\speed: (\ctlNum: 4, \default: 94), \depth: (\ctlNum: 3, \default: 8), \delay: (\ctlNum: 2, \default: 48)),
				),

				\sound: (
					\noise: (\ctlNum: 1, \default: 30),
				),

			), // end teno

			// PERCUSSIONS:

			\klung: (
				\name: "Klung",
				\type: \angklung,
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 6,
				\chan: 4,
				\power: (\ctlNum: 66),
				\panic: true,
				\range: (\default: (49..67), \extended: (69)),

				\repeats: (\ctl: \polyTouch, \global: (\ctlNum: 30)),
				\video: (\ctlNum: 67)
			),

			\springers: (
				\name: "Springers",
				\type: \springs,
				\instrumentGroup: \percussion,
				\port: 4,
				\chan: 7,
				\power: (\ctlNum: 66),
				\range: (\springs: (36..41), \shaker: [72, 73, 79, 80], \siren: 24, \light: 70)
			),

			\thunderwood: (
				\name: "Thunderwood",
				\type: \thundersheet,
				\instrumentGroup: \percussion,
				\port: 4,
				\chan: 3,
				\power: (\ctlNum: 66),
				\range: (
					\woodblock: (1..14),
					\rachet: 15,
					\rain: 16,
					\chimes: 17,
					\thundersheet: 19,
					\squeak: [21, 23],
					\bird: 22,
					\wind: 24,
					\storm: 25,
					\cricket: 26,
					\light: (
						\ctlNum: 0,
						\orange: 70,
						\green: 120,
						\red: 121,
						\yellow: 122,
						\amber: 123,
						\blue: 125
					)
				),
				\dynamics: (
					\wind: (\ctlNum: 1)
				)
			), // end Thunderwood

			\psch: (
				\name: "Psch",
				\type: \thundersheet,
				\instrumentGroup: \percussion,
				\port: 0,
				\chan: 5,
				\power: (\ctlNum: 66),
				\panic: true,
				\range: (
					\thunder: (72..83),
					\lights: (84..87)
				),

				\repeats: (\ctl: \polyTouch, \global: (\ctlNum: 30)),
			), // end Psch

			\troms: (
				\name: "Troms",
				\type: \drums,
				\instrumentGroup: \percussion,
				\port: 5,
				\chan: 6,
				\power: (\ctlNum: 66),
				\range: (
					\bassDamper: 21,
					\bassDrum: (23..29),
					\tenorDrum: (30..33),
					\altoDrum: (34..37),
					\lowBongo: (38..40),
					\highBongo: (41..43),
					\lowMiniBongo: (44..45),
					\highMiniBongo: (46..47),
					\cymbal: 48,
					\lights: (18..20)
				),
			),

			\snar: (
				\name: "Snar",
				\type: "snare drum",
				\instrumentGroup: \percussion,
				\subgroup: \unpitched,
				\port: 2,
				\chan: 6,
				\power: (\ctlNum: 66),

				\range: (
					\beaters: (60..72),
					\rimshots: (73..74),
					\light_inside: (75),
					\light_base: (76..77),
				),
				\sound: (
					\snare: (\ctlNum: 11)
				),
			),

			\vibi: (
				\name: "Vibi",
				\type: \vibraphone,
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 1,
				\chan: 10,
				\power: (\ctlNum: 66),

				\range: (\default: (60..96)),

				\dynamics: (
					\adsr: (
						r: (\ctlNum: 23, \mode: (\ctlNum: 24, \range: [0, 1, 2]), \diable: (\ctlNum: 64)) // if > 0 disables damping
					)
				),

				\tuning: (
					\vibrato: ( // actually this is a tremolo and should go to dynamics, but as the instrument is called vibraphone...
						\speed: (\ctlNum: 22, \individual: (\ctlNum: [20, 21])),
					)
				),
			), // end vibi

			\belly: (
				\name: "Belly",
				\type: \carillon,
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 0,
				\chan: 11,
				\power: (\ctlNum: 66),

				\range: (
					\default: (68..102),
					\light: (\yellow: (120..123), \white: [124, 125]),
				),

				\video: (\ctlNum: 67),
			), // end belly

			\xy: (
				\name: "Xy",
				\type: "Xylophone",
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 5,
				\chan: [2, 3],
				\power: (\ctlNum: 66),

				\range: (
					\default: (65..108),
					\lights: (127..127),
				),

			), // end Xy

			\vacca: (
				\name: "Vacca",
				\type: "Cowbells",
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 1,
				\chan: 4,
				\power: (\ctlNum: 66),

				\range: (
					\default: (48..95),
					\lights: (24..30),
				),

			), // end vacca

			\vitello: (
				\name: "Vitello",
				\type: "Cowbells",
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 4,
				\chan: 4,
				\power: (\ctlNum: 66),

				\range: (
					\default: (44..47)++(96..127),
					\lights: (\red: (12..14), \yellow: (15..18)),
				),

			), // end vitello

			\llor: (
				\name: "Llor",
				\type: \gongs,
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 6,
				\chan: 11,
				\power: (\ctlNum: 66),

				\range: (
					\hard: (36..47),
					\soft: (48..59),
					\lights: (\blue: (1..5)),
				),
			), // end Llor

			\tubi: (
				\name: "Tubi",
				\type: \tubuphone,
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 5,
				\chan: 15,
				\power: (\ctlNum: 66),

				\range: (
					\default: (72..108),
					\quartertone: (24..60),
				),

			), // end tubi

			\casta2: (
				\name: "Casta 2",
				\type: \castagnettes,
				\instrumentGroup: \percussion,
				\subgroup: \unpitched,
				\port: 0,
				\chan: 1,
				\power: (\ctlNum: 66),

				\range: (
					\default: (112..127),
					\lights: (111),
				),

			), // end Casta 2

			\temblo: (
				\name: "Temblo",
				\type: "temple blocks",
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 7,
				\chan: 12,
				\power: (\ctlNum: 66),

				\range: (
					\default: (60..65)++(72..77),
					\rachet: [69],
					\lights: (\red: (120..122), \blue: [123], \white: (124..125)++127, \nc: [126])
				),
			), // end temblo


			\bello: (
				\name: "Bello",
				\type: \bells,
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 7,
				\chan: 13,
				\power: (\ctlNum: 66),

				\range: (
					\default: [51, 57, 60, 61]++(64..93),
					\lights: [120, 126, 127],
				),

				\dynamics: (
					\ctl: \velocity;
				),

				\sound: (
					\repetition: (\ctl: \polyTouch)
				)

			), // end Bello

			\tinti: (
				\name: "Tinti",
				\type: \belld,
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 7,
				\chan: 11,
				\power: (\ctlNum: 66),

				\range: (
					\default: (89..126),
				),

				\tuning:(
					\microtuning: (
						\ctl: \pitchBend,
						\range: 1/2, // in halfsteps !!!
					),
					\demodulation: (\ctlNum: 7),
					\carrier: (\ctlNum: 8),
					\freq: (\ctlNum: 31),
				),

				\sound: (
					\shaking: (\ctlNum: 30),
				)

			), // end tinti

			\chi: (
				\name: "Chi",
				\type: \chimes,
				\instrumentGroup: \percussion,
				\subgroup: \unpitched,
				\port: 1,
				\chan: 9,
				\power: (\ctlNum: 66),
				\panic: true,

				\range: (
					\left: [96],
					\right: [97],
					\alternate: [98],
					\shake: [99],
					\gliss: (\up: [100], \down: [101], \upDown: [102])
				),

				\dynamics: (
					\wind: (\ctlNum: 7),
				),

				\tuning: (
					\carrier: (\ctlNum: 8)
				)

			), // end chi

			\per: (
				\name: "Per",
				\type: \drums,
				\instrumentGroup: \percussion,
				\subgroup: \unpitched,
				\port: 4,
				\chan: 6,
				\power: (\ctlNum: 66),
				\panic: true,

				\range: (
					\bassDrum: (\damper: 21, \pedal: 24, \beater: (\r: 25, \l: 26), \rimshot: 27),
					\darbukah: (\main: 34, \mini: 38, \LP:41),
					\bongo: (\low: 44, \high: 46),
					\motors: (\l: 58, \r: 59),
					\hiHat: (\beater: (\edge:65, \central: 67), \close: 71),
					\cymbal: [72],
					\tambourine: [77],
					\crotale: [95]
				),

			), // end per

			\tubo: (
				\name: "Tubo",
				\type: "tubular bells",
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 7,
				\chan: 4,
				\power: (\ctlNum: 66),
				\panic: true,

				\range: (
					\default: (48..91),
					\lights: (120..126),
				),

				\dynamics: (
					\adsr: (
						\r: (\ctlNum: 25, \deactivate: 64),
					)
				),

				\tuning: (
					\vibrato: (\speed: (\global: (\ctlNum: 22), \low: (\ctlNum: 20), \high: (\ctlNum: 21))),
				)

			), // end Tubo


			\steely: (
				\name: "Steely",
				\type: "Steel drum",
				\instrumentGroup: \percussion,
				\subgroup: \pitched,
				\port: 0,
				\chan: 7,
				\power: (\ctlNum: 66),
				\panic: true,

				\range: (
					\default: [65, 67, 69, 72, 74, 77, 79, 81],
					\lights: (\auto: (\ctlNum: 69)),
				),
				\dynamics: (
					\repetitions: (\p: (\ctlNum: 30), \ctl: \polyTouch)
				),

			), // end steely

			// KEYS:

			\pp2: (
				\name: "Pp2",
				\type: "Piano",
				\instrumentGroup: \keys,
				\subgroup: \pianos,
				\port: 3,
				\chan: 0,
				\power: (\ctlNum: 66),
				\panic: true,

				\range: (
					\default: (21..108),
					\lights: (120..127)
				),

				\dynamics: (
					\adsr: (
						\r: (\ctlNum: 64)
					),
				)

			), // end pp2

			\spiro: (
				\name: "Spiro",
				\type: \spinett,
				\instrumentGroup: \keys,
				\subgroup: \cembalos,
				\port: 0,
				\chan: 4,
				\power: (\ctlNum: 66),

				\dynamics: (),

				\range: (
					\default: (33..88),
				),

				\sound: (
					\muffler: (\bass: (\ctlNum: 28), \treble: (\ctlNum: 29))
				),

			), // end spiro

			\toypi: (
				\name: "ToyPi",
				\type: "toy piano",
				\instrumentGroup: \keys,
				\subgroup: \pianos,
				\port: 2,
				\chan: 10,
				\power: (\ctlNum: 66),

				\range: (
					\default: (72..107),
					\lights: (48..53)++(60..67)
				),

			), // end toypi

			\rodo: (
				\name: "Rodo",
				\type: \tines,
				\instrumentGroup: \keys,
				\subgroup: \pianos,
				\port: 7,
				\chan: 7,
				\power: (\ctlNum: 66),

				\range: (
					\default: (48..78),
					\lights: (112..127)
				),

				\dynamics: (
					\adsr: (
						\a: (\ctlNum: 17),
						\d: (\ctlNum: 18),
						\s: (\ctlNum: 7), // doublecheck that
						\r: (\ctlNum: 19),
					),
				),

				\tuning: (
					\microtuning: (
						\ctl: \pitchBend,
						\range: 1/2,
					),
				),

				\sound: (
					\ebow: (\ctlNum: 3,
						\jitter: (\ctlNum: 1),
						\wave: (\ctlNum: 2),
						\feedback: (\ctlNum: 4),
						\inject: (\ctlNum: 5),
						\note_or_key: (\ctlNum: 6)
					)
				)

			), // end toypi

			// STRINGS:

			\aeio: (
				\name: "Aeio",
				\type: \harp,
				\instrumentGroup: \strings,
				\subgroup: \unique,
				\port: 7,
				\chan: 1,
				\power: (\ctlNum: 66),

				\range: (
					\hammers: (24..35),
					\exciters: (36..127),
					\lights: (\blue: 1, \red: 2, \yellow: [5, 6]),
				),

				\dynamics: (
					\wind: (\ctlNum: 7),
					\adsr: (
						\r: (\ctlNum: 64, \ctl2: 65) // check for details
					)
				),

				\tuning: (
					\microtuning: (\ctlNum:(80..91), \ctl: \seq),
					\overtoneMode: (\ctlNum: (100..111)),
				),

				\sound: (
					\wave: (\symmetry: (\ctlNum: (30..41), \default: 64)),
				),

				\radar: (
					\on: (\ctlNum: 79, \default: 127), // doublecheck that
					\params: (\ctlNum: (70..78)),
				)

			), // end aeio




			// SPECIAL :

			\dripper: (
				\name: "Dripper",
				\type: "dripping machine",
				\instrumentGroup: \special,
				\subgroup: \unique,
				\port: 2,
				\chan: 14,
				\power: (\ctlNum: 66),

				\range: (
					\default: (21..108),
				),

			), // end dripper

			\sire: (
				\name: "Sire",
				\type: "Sirens",
				\instrumentGroup: \special,
				\subgroup: \unique,
				\port: 0,
				\chan: 12,
				\power: (\ctlNum: 66),

				\range: (
					\default: (48..71),
					\lights: (84..92),
				),

				\tuning: (
					\ctlNum: (48..71)
				),

			), // end sire

			\flex: (
				\name: "Flex",
				\type: "singing saw",
				\instrumentGroup: \special,
				\subgroup: \unique,
				\port: 9,
				\chan: 12,
				\power: (\ctlNum: 66),
				\panic: true,

				\dynamics: (),

				\range: (
					\bending: (
						\saw: (
							\pi: (position: [36],full_stretch: [38],full_bend: [40]),
							\e: (position: [37], full_stretch: [39], full_bend: [41]),
						),
					),
					\bowing: (
						\frontbow: (\cw: [48], \ccw: [49], \pi: [60], \e: [61], \center: [64], \brake: [66]),
						\backbow: (\cw: [50], \ccw: [51], \pi: [62], \e: [63], \center: [65],  \brake: [67]),
					),
					\beaters: (
						\pi: (
							\front: (\motor: [72], \beater: [74]),
							\back: (\motor: [73], \beater: [75]),
						),
						\e: (
							\front: (\motor: [84], \beater: [86]),
							\back: (\motor: [85], \beater: [87]),
						)
					),
					\lights: (120..127),
				),
			), // end flex
			\kazumi: (
				\name: "Kazumi",
				\type: "kazoo",
				\instrumentGroup: \wind,
				\subgroup: \wood,
				\port: 4,
				\chan: 14,
				\power: (\ctlNum: 66), // resets also to default
				\panic: true,
				\reset: (\ctlNum: 121),

				\range: (
					\default: (36..94),
					\lights: (\ctlNum: (120..122)),
				),

				\lights: (\ctlNum: 69), // automode

				\dynamics: (
					\wind: (\ctlNum: 7, \default: 60),
					\scaling: (\ctlNum: 80, \default: 62),
					\range: (\ctlNum: 80, \default: 32),
					\tremolo: (\depth: (\ctlNum: 5), \speed: (\ctlNum: 6)),
					\adsr: (
						\a: (\ctlNum: 16, \amp: (\ctlNum: 17)),
						\d: (\ctlNum: 18),
						\s: (\ctl: \velocity),
						\r: (\ctlNum: 19),
						\period: (\ctlNum: 15),
					),
				),
				\tuning: (
					\global: (\ctlNum: 20, \default: 64),
					\vibrato: (\delay: (\ctlNum: 2), \depth: (\ctlNum: 3, \default: 8), \speed: (\ctlNum:4, \default: 94), \depth2: (\ctlNum: 5, \default: 4), \speed2: (\ctlNum: 4, \default: 20)),
					\microtuning: (\ctl: \pitchBend, \range: 1/2),
					// \vibrato: (
					// \speed: (\ctlNum: 22, \individual: (\ctlNum: [20, 21])),
					// )
				),
				\sound: (
					\noise: (\ctlNum: 1),
					\valve: (\force: (\ctlNum: 11)),
					//\wave: (\ctlNum: 25, \registers: (\ctlNum: (41..43))), // TO DO
				),

				\position: (
					\horizontal: (\ctlNum: 10, default: 63, \speed: (\ctlNum: 31), \acceleration: (\ctlNum: 32)),
					\calibrate: (\ctlNum: 71),
				)
			), // end kazumi

		); // end ~logos.instruments
	}
}