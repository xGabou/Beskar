execute as @a[gamemode=!creative,gamemode=!spectator] at @s if dimension customplanets:planet_mandalore if predicate customplanets:mandalore/spawn_patrol unless entity @e[tag=mandalore_patrol,distance=..128,limit=1] run function customplanets:mandalore/spawn_patrol

