$src = 'C:\Users\matga\.gradle\caches\ng_execute\08e6b5a313bad0d3dcb140ee37caf74194e6588729c1bcb38539c58b1ea9749c\transformed\data\minecraft\worldgen\noise_settings\overworld.json'
$dst = 'G:\mods\Beskar\src\main\resources\data\customplanets\worldgen\noise_settings\settings_mandalore.json'

New-Item -ItemType Directory -Force -Path (Split-Path $dst) | Out-Null

$root = Get-Content -Raw $src | ConvertFrom-Json -Depth 100
$biomes = @(
    'customplanets:biome_mandalore_scorched_wastelands',
    'customplanets:biome_mandalore_ash_dunes',
    'customplanets:biome_mandalore_glassed_desert',
    'customplanets:biome_mandalore_ruined_city',
    'customplanets:biome_mandalore_cracked_basin',
    'customplanets:biome_mandalore_bombarded_flats',
    'customplanets:biome_mandalore_dead_forge_fields',
    'customplanets:biome_mandalore_toxic_ruins',
    'customplanets:biome_mandalore_blackened_canyon',
    'customplanets:biome_mandalore_raider_zones'
)

$surfaceRuleJson = @'
{
  "type": "minecraft:sequence",
  "sequence": [
    {
      "type": "minecraft:condition",
      "if_true": {
        "type": "minecraft:vertical_gradient",
        "false_at_and_above": { "above_bottom": 5 },
        "random_name": "minecraft:bedrock_floor",
        "true_at_and_below": { "above_bottom": 0 }
      },
      "then_run": {
        "type": "minecraft:block",
        "result_state": { "Name": "minecraft:bedrock" }
      }
    },
    {
      "type": "minecraft:condition",
      "if_true": { "type": "minecraft:above_preliminary_surface" },
      "then_run": {
        "type": "minecraft:sequence",
        "sequence": [
          {
            "type": "minecraft:condition",
            "if_true": {
              "type": "minecraft:biome",
              "biome_is": []
            },
            "then_run": {
              "type": "minecraft:sequence",
              "sequence": [
                {
                  "type": "minecraft:condition",
                  "if_true": {
                    "type": "minecraft:stone_depth",
                    "add_surface_depth": false,
                    "offset": 0,
                    "secondary_depth_range": 0,
                    "surface_type": "floor"
                  },
                  "then_run": {
                    "type": "minecraft:sequence",
                    "sequence": [
                      {
                        "type": "minecraft:condition",
                        "if_true": {
                          "type": "minecraft:noise_threshold",
                          "noise": "customplanets:mandalore_debris",
                          "min_threshold": 0.78,
                          "max_threshold": 1000000.0
                        },
                        "then_run": {
                          "type": "minecraft:sequence",
                          "sequence": [
                            {
                              "type": "minecraft:condition",
                              "if_true": {
                                "type": "minecraft:noise_threshold",
                                "noise": "customplanets:mandalore_primary",
                                "min_threshold": -1000000.0,
                                "max_threshold": -0.2
                              },
                              "then_run": {
                                "type": "minecraft:block",
                                "result_state": { "Name": "minecraft:stone" }
                              }
                            },
                            {
                              "type": "minecraft:block",
                              "result_state": { "Name": "minecraft:gravel" }
                            }
                          ]
                        }
                      },
                      {
                        "type": "minecraft:condition",
                        "if_true": {
                          "type": "minecraft:noise_threshold",
                          "noise": "customplanets:mandalore_debris",
                          "min_threshold": 0.6,
                          "max_threshold": 0.78
                        },
                        "then_run": {
                          "type": "minecraft:block",
                          "result_state": { "Name": "minecraft:gravel" }
                        }
                      },
                      {
                        "type": "minecraft:condition",
                        "if_true": {
                          "type": "minecraft:noise_threshold",
                          "noise": "customplanets:mandalore_primary",
                          "min_threshold": -0.35,
                          "max_threshold": 1000000.0
                        },
                        "then_run": {
                          "type": "minecraft:sequence",
                          "sequence": [
                            {
                              "type": "minecraft:condition",
                              "if_true": {
                                "type": "minecraft:noise_threshold",
                                "noise": "customplanets:mandalore_variant",
                                "min_threshold": -1000000.0,
                                "max_threshold": -0.2
                              },
                              "then_run": {
                                "type": "minecraft:block",
                                "result_state": { "Name": "beskar:green_crystal_block" }
                              }
                            },
                            {
                              "type": "minecraft:condition",
                              "if_true": {
                                "type": "minecraft:noise_threshold",
                                "noise": "customplanets:mandalore_variant",
                                "min_threshold": -0.2,
                                "max_threshold": 0.35
                              },
                              "then_run": {
                                "type": "minecraft:block",
                                "result_state": { "Name": "beskar:green_crystal_block_floor" }
                              }
                            },
                            {
                              "type": "minecraft:block",
                              "result_state": { "Name": "beskar:green_crystal_block_floor_cracked" }
                            }
                          ]
                        }
                      },
                      {
                        "type": "minecraft:sequence",
                        "sequence": [
                          {
                            "type": "minecraft:condition",
                            "if_true": {
                              "type": "minecraft:noise_threshold",
                              "noise": "customplanets:mandalore_variant",
                              "min_threshold": 0.55,
                              "max_threshold": 1000000.0
                            },
                            "then_run": {
                              "type": "minecraft:block",
                              "result_state": { "Name": "beskar:green_crystal_block_floor_cracked" }
                            }
                          },
                          {
                            "type": "minecraft:condition",
                            "if_true": {
                              "type": "minecraft:noise_threshold",
                              "noise": "customplanets:mandalore_debris",
                              "min_threshold": 0.45,
                              "max_threshold": 1000000.0
                            },
                            "then_run": {
                              "type": "minecraft:block",
                              "result_state": { "Name": "minecraft:gravel" }
                            }
                          },
                          {
                            "type": "minecraft:block",
                            "result_state": { "Name": "minecraft:stone" }
                          }
                        ]
                      }
                    ]
                  }
                },
                {
                  "type": "minecraft:condition",
                  "if_true": {
                    "type": "minecraft:stone_depth",
                    "add_surface_depth": true,
                    "offset": 0,
                    "secondary_depth_range": 2,
                    "surface_type": "floor"
                  },
                  "then_run": {
                    "type": "minecraft:sequence",
                    "sequence": [
                      {
                        "type": "minecraft:condition",
                        "if_true": {
                          "type": "minecraft:noise_threshold",
                          "noise": "customplanets:mandalore_debris",
                          "min_threshold": 0.6,
                          "max_threshold": 1000000.0
                        },
                        "then_run": {
                          "type": "minecraft:block",
                          "result_state": { "Name": "minecraft:gravel" }
                        }
                      },
                      {
                        "type": "minecraft:condition",
                        "if_true": {
                          "type": "minecraft:noise_threshold",
                          "noise": "customplanets:mandalore_primary",
                          "min_threshold": -0.35,
                          "max_threshold": 1000000.0
                        },
                        "then_run": {
                          "type": "minecraft:block",
                          "result_state": { "Name": "beskar:green_crystal_block_floor" }
                        }
                      },
                      {
                        "type": "minecraft:condition",
                        "if_true": {
                          "type": "minecraft:noise_threshold",
                          "noise": "customplanets:mandalore_variant",
                          "min_threshold": 0.55,
                          "max_threshold": 1000000.0
                        },
                        "then_run": {
                          "type": "minecraft:block",
                          "result_state": { "Name": "beskar:green_crystal_block_floor_cracked" }
                        }
                      },
                      {
                        "type": "minecraft:block",
                        "result_state": { "Name": "minecraft:stone" }
                      }
                    ]
                  }
                }
              ]
            }
          }
        ]
      }
    },
    {
      "type": "minecraft:condition",
      "if_true": {
        "type": "minecraft:vertical_gradient",
        "false_at_and_above": { "absolute": 8 },
        "random_name": "minecraft:deepslate",
        "true_at_and_below": { "absolute": 0 }
      },
      "then_run": {
        "type": "minecraft:block",
        "result_state": {
          "Name": "minecraft:deepslate",
          "Properties": { "axis": "y" }
        }
      }
    }
  ]
}
'@

$surfaceRule = $surfaceRuleJson | ConvertFrom-Json -Depth 100
$surfaceRule.sequence[1].then_run.sequence[0].if_true.biome_is = $biomes
$root.surface_rule = $surfaceRule
$root | ConvertTo-Json -Depth 100 | Set-Content -Path $dst
