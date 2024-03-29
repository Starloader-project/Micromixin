package org.stianloader.micromixin.transform.internal.annotation;

import java.util.Collection;

import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.tree.ClassNode;
import org.stianloader.micromixin.transform.SimpleRemapper;
import org.stianloader.micromixin.transform.internal.HandlerContextHelper;
import org.stianloader.micromixin.transform.internal.MixinStub;

public abstract class MixinAnnotation<T> implements Comparable<MixinAnnotation<T>> {
    public abstract void apply(@NotNull ClassNode to, @NotNull HandlerContextHelper hctx, @NotNull MixinStub sourceStub, @NotNull T source, @NotNull SimpleRemapper remapper, @NotNull StringBuilder sharedBuilder);

    @Override
    public int compareTo(MixinAnnotation<T> o) {
        return o.getClass().getName().compareTo(this.getClass().getName());
    }

    public boolean isCompatible(Collection<MixinAnnotation<T>> collection) {
        return true;
    }

    public abstract void collectMappings(@NotNull T source, @NotNull ClassNode target, @NotNull SimpleRemapper remapper, @NotNull StringBuilder sharedBuilder);
}
