package de.geolykt.micromixin.internal;

import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class HandlerContextHelper {

    @NotNull
    public final String handlerPrefix;
    public int handlerCounter = 0;

    public HandlerContextHelper(@NotNull String handlerPrefix) {
        this.handlerPrefix = handlerPrefix;
    }

    @SuppressWarnings("null")
    @NotNull
    public static HandlerContextHelper from(@NotNull ClassNode node) {
        String[] methodNames = new String[node.methods.size()];
        int n = 0;
        for (MethodNode method : node.methods) {
            methodNames[n++] = method.name;
        }
        for (String s : methodNames) {
            if (s.startsWith("$handler$")) {
                String prefix;
                int i = 0;
                outer:
                while (true) {
                    prefix = "$handler$" + i + "$";
                    for (String mname : methodNames) {
                        if (mname.startsWith(prefix)) {
                            continue outer;
                        }
                    }
                    break;
                }
                return new HandlerContextHelper(prefix);
            }
        }
        return new HandlerContextHelper("$handler$");
    }
}
