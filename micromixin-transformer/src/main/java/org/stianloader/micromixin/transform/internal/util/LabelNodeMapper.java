package org.stianloader.micromixin.transform.internal.util;

import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.tree.LabelNode;

public interface LabelNodeMapper {

    @NotNull
    LabelNode apply(LabelNode source);
}
