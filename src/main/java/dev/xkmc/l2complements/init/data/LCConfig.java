package dev.xkmc.l2complements.init.data;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import org.apache.commons.lang3.tuple.Pair;

public class LCConfig {

	public static class Client {

		public final ForgeConfigSpec.BooleanValue showInfo;

		Client(ForgeConfigSpec.Builder builder) {
			showInfo = builder.comment("Show combined bow arrow stats and features when holding bow")
					.define("showInfo", true);
		}

	}

	public static class Common {

		public final ForgeConfigSpec.DoubleValue windSpeed;
		public final ForgeConfigSpec.IntValue belowVoid;
		public final ForgeConfigSpec.IntValue phantomHeight;
		public final ForgeConfigSpec.IntValue explosionDamage;
		public final ForgeConfigSpec.IntValue spaceDamage;

		public final ForgeConfigSpec.DoubleValue shulkerateReach;

		public final ForgeConfigSpec.DoubleValue windSweepIncrement;

		public final ForgeConfigSpec.IntValue soulFireChargeDuration;
		public final ForgeConfigSpec.IntValue blackFireChargeDuration;
		public final ForgeConfigSpec.IntValue strongFireChargePower;

		public final ForgeConfigSpec.DoubleValue emeraldDamageFactor;
		public final ForgeConfigSpec.IntValue emeraldBaseRange;

		public final ForgeConfigSpec.IntValue iceEnchantDuration;
		public final ForgeConfigSpec.IntValue flameEnchantDuration;

		Common(ForgeConfigSpec.Builder builder) {
			builder.push("materials");
			windSpeed = builder.comment("Requirement for obtaining Captured Wind. Unit: Block per Tick")
					.defineInRange("windSpeed", 10, 0.1, 100);
			belowVoid = builder.comment("Requirement for void eye drop")
					.defineInRange("belowVoid", 16, 0, 128);
			phantomHeight = builder.comment("Requirement for sun membrane drop")
					.defineInRange("phantomHeight", 200, 0, 10000);
			explosionDamage = builder.comment("Requirement for explosion shard drop")
					.defineInRange("explosionDamage", 80, 1, 10000);
			spaceDamage = builder.comment("Requirement for space shard drop")
					.defineInRange("spaceDamage", 2048, 1, 10000);
			builder.pop();

			builder.push("fire charge");
			soulFireChargeDuration = builder.comment("Soul Fire Charge Duration")
					.defineInRange("soulFireChargeDuration", 60, 1, 10000);
			blackFireChargeDuration = builder.comment("Black Fire Charge Duration")
					.defineInRange("blackFireChargeDuration", 100, 1, 10000);
			strongFireChargePower = builder.comment("Strong Fire Charge Power")
					.defineInRange("strongFireChargePower", 2, 1, 10);
			builder.pop();

			builder.push("properties");
			shulkerateReach = builder.comment("Shulkerate reach increment")
					.defineInRange("shulkerateReach", 1, 0.1, 100);
			windSweepIncrement = builder.comment("Wind Sweep enchantment increment to sweep hit box")
					.defineInRange("windSweepIncrement", 1, 0.1, 100);
			emeraldDamageFactor = builder.comment("Damage factor of emerald splash")
					.defineInRange("emeraldDamageFactor", 0.5, 0.001, 1000);
			emeraldBaseRange = builder.comment("Base range for emerald splash")
					.defineInRange("emeraldBaseRange", 10, 1, 100);
			iceEnchantDuration = builder.comment("Base duration for iceBlade")
					.defineInRange("iceEnchantDuration", 100, 1, 10000);
			flameEnchantDuration = builder.comment("Duration for flameBlade")
					.defineInRange("flameEnchantDuration", 60, 1, 10000);
			builder.pop();

		}

	}

	public static final ForgeConfigSpec CLIENT_SPEC;
	public static final Client CLIENT;

	public static final ForgeConfigSpec COMMON_SPEC;
	public static final Common COMMON;

	static {
		final Pair<Client, ForgeConfigSpec> client = new ForgeConfigSpec.Builder().configure(Client::new);
		CLIENT_SPEC = client.getRight();
		CLIENT = client.getLeft();

		final Pair<Common, ForgeConfigSpec> common = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = common.getRight();
		COMMON = common.getLeft();
	}

	/**
	 * Registers any relevant listeners for config
	 */
	public static void init() {
		ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.CLIENT, LCConfig.CLIENT_SPEC);
		ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, LCConfig.COMMON_SPEC);
	}


}
