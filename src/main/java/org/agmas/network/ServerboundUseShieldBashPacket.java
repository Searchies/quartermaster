package org.agmas.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.agmas.porting.QMIdentifier;

/*
 *  Only used by 26.3 since the swing packet is removed
 */
public record ServerboundUseShieldBashPacket(boolean helloMyNameIsTungTung) implements CustomPacketPayload {
    public static final Type<ServerboundUseShieldBashPacket> TYPE = new Type<>(QMIdentifier.of("shield_bash").id);
    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundUseShieldBashPacket> CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, ServerboundUseShieldBashPacket::helloMyNameIsTungTung, ServerboundUseShieldBashPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
