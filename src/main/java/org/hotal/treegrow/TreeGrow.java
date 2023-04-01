package org.hotal.treegrow;

import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TreeGrow extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // イベントリスナーを登録
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        // Shiftキーが押されたかをチェック
        if (!player.isSneaking()) {
            return;
        }

        // ブロックがクリックされたかをチェック
        Block block = event.getClickedBlock();
        if (block == null) {
            return;
        }

        // クリックされたブロックが土でなければ処理を終了
        if (block.getType() != Material.DIRT && block.getType() != Material.GRASS_BLOCK) {
            return;
        }

        // ツリーを成長させる
        block.getWorld().generateTree(block.getLocation(), TreeType.TREE);
    }
}


