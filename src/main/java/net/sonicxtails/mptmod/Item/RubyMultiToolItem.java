package net.sonicxtails.mptmod.Item;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.LivingEntity;

public class RubyMultiToolItem extends Item {

    public RubyMultiToolItem(Properties properties) {
        super(properties);
    }

    // Метод для проверки, может ли инструмент добывать данный блок
    public boolean canHarvestBlock(BlockState state) {
        return true; // Позволяет инструменту добывать любой блок
    }

    // Метод для определения скорости добычи блока
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return 12.0f; // Скорость добычи, вы можете настроить ее по вашему усмотрению
    }

    // Переопределение метода, чтобы инструмент мог использоваться как мотыга и добывать блоки
    @Override
    public InteractionResult useOn(UseOnContext context) {
        // Получаем информацию о месте клика и игроке
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer(); // Получаем игрока
        ItemStack stack = context.getItemInHand();

        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        // Проверяем, является ли блок, по которому кликнули, блоком земли
        if (block == Blocks.DIRT || block == Blocks.GRASS_BLOCK) {
            // Делаем грядку
            if (!world.isClientSide) {
                world.setBlockAndUpdate(pos, Blocks.FARMLAND.defaultBlockState());
                // Уменьшаем прочность инструмента
                stack.hurtAndBreak(1, player, (p) -> {
                    p.broadcastBreakEvent(context.getHand());
                });
            }
            return InteractionResult.SUCCESS; // Возвращаем SUCCESS, если действие выполнено
        } else {
            // Добавим проверку, может ли инструмент добывать данный блок
            if (!canHarvestBlock(state)) {
                return InteractionResult.PASS; // Если инструмент не может добывать данный блок, пропустить
            }

            // Получаем предмет, который добыли
            ItemStack result = new ItemStack(block.asItem());

            // Добавим предмет в инвентарь игрока или выкинем его на землю
            if (!player.getInventory().add(result)) {
                Block.popResource(world, pos, result);
            }

            // Уменьшаем прочность инструмента
            stack.hurtAndBreak(1, player, (p) -> {
                p.broadcastBreakEvent(context.getHand());
            });

            // Удаляем блок из мира
            world.removeBlock(pos, false);

            return InteractionResult.SUCCESS; // Возвращаем SUCCESS, если действие выполнено
        }
    }

    // Метод для нанесения урона мобам
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player) {
            target.hurt(DamageSource.GENERIC, 1000.0f);
            return true;
        }
        return false;
    }
}
