# Micromixin

Micromixin is a lightweight reimplementation of Spongepowered's Mixin framework.

## Why reimplement?

The astute among you may be painfully aware that reimplementing any large framework is
a very time-consuming process. However, with Mixin I believe that the pain of staying
with the official implementation would be stronger than attempting to reimplement it
in a decent fashion. <b>By no means is it a full reimplementation</b>, but we try to
keep compatibility whereever possible.

Painpoints of the official Mixin implementation that this implementation seeks to avoid:
 - Mixin's JPMS being an absolute hellscape
 - Mixin being very hard to use outside it's intended habitat (keyword: Modlauncher)
 - Mixin being reliant on outdated libraries
 - Service hell
 - Not being present on OSSRH. (As of now this is an afterthought, not actually done)
 - Dependency hell (Only org.json:json and objectweb's asm is needed under micromixin)
 - Integration with newer Java versions being confusing at best
 - Sponge's Mixins supports operand stack manipulation by declaring @Inject handlers
   as something other than void (see
   <https://discord.com/channels/142425412096491520/626802111455297538/1075864621589733387>
   ). Micromixin rejects that practice and will POP/POP2 such operands as that leads
   to unstable behaviour.
 - Mixin using Java 8 (Micromixin uses Java 6, making it usable for some more niche
   purposes)

## Modules

The Micromixin framework comes in three modules. "micromixin-annotations" includes
all the traditional mixin annotations that are implemented by Micromixin - nothing more.
"micromixin-transformer" includes the transformer and all other parts required to
run micromixin. "micromixin-test-j8" includes tests for Micromxin and is the least
interesting part of the project.

Warning: <b>Do not use micromixin-annotations and micromixin-transformer at the same
time!</b> They provide overlapping classes which can cause havoc at runtime.
Micromixin-annotations should strictly be used for compilation and
micromixin-transformer should strictly be used for runtime transformation.
