package dev.local.voxyquietchat.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Voxy sends every Logger.error() line to the chat through Logger.showInHUD(String).
 * The message starts with the abbreviated class name (e.g. "me.cx.vy.ct.ce.rg.hl.NodeManager"),
 * so only messages from the classes listed below are dropped. The log file still receives them.
 */
@Mixin(targets = "me.cortex.voxy.common.Logger", remap = false)
public abstract class VoxyLoggerMixin {
	private static final String[] HIDDEN_SOURCES = {
		"NodeManager",
		"AbstractSectionRenderer",
	};

	@Inject(method = "showInHUD", at = @At("HEAD"), cancellable = true)
	private static void voxyquietchat$hideNoisy(String message, CallbackInfo ci) {
		if (message == null) {
			return;
		}
		for (String source : HIDDEN_SOURCES) {
			if (message.contains(source)) {
				ci.cancel();
				return;
			}
		}
	}
}
