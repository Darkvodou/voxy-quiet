# Voxy Quiet Chat

A tiny client-side Fabric mod that hides noisy [Voxy](https://modrinth.com/mod/fxxUqruK) warnings from the in-game chat.

Voxy sends every internal error to the chat. Some of them are harmless and very frequent, for example:

```
[me.cx.vy.ct.ce.rg.hl.NodeManager]: Transforming inner node to leaf node while it has null geometry
[me.cx.vy.ct.ce.rg.sn.bd.AbstractSectionRenderer]: Failed to compile shader patch, using normal pipeline to prevent errors
```

This mod hides the messages coming from `NodeManager` and `AbstractSectionRenderer`. Other Voxy errors still show in the chat, and every message is still written to `latest.log`.

## How it works

A single mixin cancels `me.cortex.voxy.common.Logger.showInHUD(String)` when the message comes from one of the classes listed in `VoxyLoggerMixin`.

## Requirements

- Minecraft 26.3
- Fabric Loader 0.19.5+
- Voxy

## Building

Requires Java 25.

```
./gradlew build
```

The jar is written to `build/libs/`.

## License

MIT. See [LICENSE](LICENSE).
