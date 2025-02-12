package dev.teamcitrus.demeter.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record QualityDataComponent(Quality quality) {
    public static final Codec<QualityDataComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Quality.CODEC.fieldOf("quality").forGetter(QualityDataComponent::quality)
    ).apply(instance, QualityDataComponent::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, QualityDataComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Quality.CODEC), QualityDataComponent::quality,
            QualityDataComponent::new
    );
}
