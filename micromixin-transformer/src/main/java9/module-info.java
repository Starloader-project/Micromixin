module de.geolykt.starloader.micromixin {
    requires org.objectweb.asm;
    requires org.objectweb.asm.commons;
    requires org.objectweb.asm.tree;
    requires org.objectweb.asm.util;
    requires org.json;
    requires org.jetbrains.annotations;

    exports de.geolykt.micromixin;
    exports de.geolykt.micromixin.supertypes;
    exports org.spongepowered.asm.mixin.injection.callback;
}
