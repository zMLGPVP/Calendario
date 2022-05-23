package me.datas.main;

import java.util.Arrays;
import java.util.Calendar;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public void onEnable() {
		Sistema();
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@SuppressWarnings("deprecation")
	public void Sistema() {
		Calendar c = Calendar.getInstance();
		// int month = c.get(Calendar.MONTH);
		int days = c.get(Calendar.DAY_OF_MONTH);

		Inventory inv = Bukkit.createInventory(null, 54, "§b§nCalendario");
		ItemStack item = CreateItem.itemStack(
				Material.STAINED_GLASS_PANE, "§aDia §f" + days + "§a  hoje", Arrays.asList("",
						"§aHoje  dia §f" + days, "§7Voc� ja pode coletar o seu presente", "§e(Apenas Clique)", ""),
				days, 11);
		for (int i = 1; i < 8; i++) {
			ItemStack items = CreateItem.itemStack(Material.STAINED_GLASS_PANE, "�cDia �f" + i, i, 15);
				inv.setItem(i, items);
				if (i == days) {
				inv.setItem(i, item);
			}
		}
		for (int i = 10; i < 17; i++) {
			int io = i - 2;
			ItemStack items = CreateItem.itemStack(Material.STAINED_GLASS_PANE, "�cDia �f" + io, io, 15);
				inv.setItem(i, items);
				if (io == days) {
				inv.setItem(i, item);
			}
		}
		for (int i = 19; i < 26; i++) {
			int io = i - 3;
			ItemStack items = CreateItem.itemStack(Material.STAINED_GLASS_PANE, "�cDia �f" + io, io, 15);
				inv.setItem(i, items);
				if (io == days) {
				inv.setItem(i, item);
			}
		}
		for (int i = 28; i < 35; i++) {
				int io = i - 5;
				ItemStack items = CreateItem.itemStack(Material.STAINED_GLASS_PANE, "�cDia �f" + io, io, 15);
				inv.setItem(i, items);
				if (io == days) {
				inv.setItem(i, item);
			}
		}
		for (int i = 37; i < 39; i++) {
				int io = i - 7;
				ItemStack items = CreateItem.itemStack(Material.STAINED_GLASS_PANE, "�cDia �f" + io, io, 15);
				inv.setItem(i, items);
				if (io == days) {
				inv.setItem(i, item);
			}
		}

		for (Player p : Bukkit.getOnlinePlayers()) {
			p.openInventory(inv);
		}
	}

	@EventHandler
		public void onClickInv(InventoryClickEvent e) {

		Player p = (Player) e.getWhoClicked();
		
		if (e.getClickedInventory() == null)
				return;
		if (e.getClickedInventory().getTitle() == null)
				return;
		if (e.getCurrentItem() == null)
				return;
		if (e.getCurrentItem().getItemMeta() == null)
				return;

		if (e.getCurrentItem().getItemMeta().getDisplayName() == null)
				return;

		if (e.getInventory().getTitle().equalsIgnoreCase("§b§nCalendario")) {
				e.setCancelled(true);
				Calendar c = Calendar.getInstance();
				int days = c.get(Calendar.DAY_OF_MONTH);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aDia �f" + days + "�a � hoje")) {
				p.closeInventory();
				p.sendMessage("§aParabens você coletou o presente do dia: dias " + days);
			}

		}
	}
	//Coloca mais coisas depois!
}
