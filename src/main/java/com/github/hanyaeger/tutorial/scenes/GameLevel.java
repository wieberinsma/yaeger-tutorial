package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMapContainer;
import com.github.hanyaeger.api.engine.scenes.DynamicScene;
import com.github.hanyaeger.api.engine.scenes.EntitySpawnerContainer;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.*;
import com.github.hanyaeger.tutorial.entities.map.CoralTileMap;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.spawners.BubbleSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

    private Waterworld waterworld;

    public GameLevel(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
        setBackgroundAudio("audio/waterworld.mp3");
    }

    @Override
    public void setupEntities() {
        var healthText = new HealthText(new Location(0, 0));
        addEntity(healthText);

        var bubblesPoppedText = new BubblesPoppedText(new Location(0, 30));
        addEntity(bubblesPoppedText);

        addEntity(new Hanny(new Location(0, 0), healthText, bubblesPoppedText, waterworld));
        addEntity(new Swordfish(new Location(200, 300)));
        addEntity(new Sharky(new Location(0, 100)));
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new BubbleSpawner(getWidth(), getHeight()));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new CoralTileMap());

    }
}
