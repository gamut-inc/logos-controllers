# Logos Controllers

Software for composing for the robot orchestra of the
[Logos Foundation](https://www.logosfoundation.org) in Ghent: several dozen
automated acoustic instruments — organs, winds, percussion, strings — built by
Godfried-Willem Raes and played over MIDI.

Every one of these instruments is addressed differently. Wind pressure is
controller 7 on one and controller 1 on the next; some need to be switched on
before they sound; quarter tones are a second MIDI channel here and pitch bend
there; ranges differ, and so does what velocity means. Writing for the orchestra
means carrying sixty instrument manuals in your head.

This repository holds two ways of not having to.

## `max-for-live/` — one device per instrument

49 Max for Live devices. Each one sits on a MIDI track in Ableton Live and
exposes the controls of one instrument by name — dynamics, envelope, tremolo and
whatever else it has — so they can be automated like any other parameter. There are
separate devices for the two channels of the quarter-tone instruments, a generic
device, and `Logos_controller_ALL`, which combines them.

They need Ableton Live with Max for Live.

## `supercollider/` — the orchestra as a pattern target

Two SuperCollider classes.

`LogosInstruments` describes 60 instruments as data: port, channel, range,
power switch, dynamics controllers, microtuning method, panic behaviour.

`Logos` uses that description to turn ordinary patterns into the right MIDI. It
registers an event type, so an instrument is chosen by name and fractional note
numbers come out as whatever that instrument uses for microtones:

```supercollider
Pbind(
    \type, \logos,
    \instrument, \qt,          // the quarter-tone organ
    \midinote, Pseq([60, 60.5, 61, 61.5], inf),
    \velocity, 64,
    \dur, 0.5
).play;

Logos.power(\qt);              // switch the instrument on
Logos.wind(\qt, 100);          // wind pressure, on whichever controller it uses
Logos.subgroup(\wood);         // instruments by family
Logos.panicAll;
```

Copy both files into the SuperCollider extensions folder. `Logos.toSimpleMIDIFile`
additionally needs the `SimpleMIDIFile` class from wslib.

## State

Working tools, written for our own pieces and published as they are. The
classes were taken out of a larger private library and have not been tested on
their own; the devices were built one at a time over several years and are not
uniform. The instrument data comes from the Logos Foundation's documentation and
from work on site — corrections are welcome.

## Licence

MIT — see [LICENSE](LICENSE). The instruments themselves are the work of
Godfried-Willem Raes and the Logos Foundation.
