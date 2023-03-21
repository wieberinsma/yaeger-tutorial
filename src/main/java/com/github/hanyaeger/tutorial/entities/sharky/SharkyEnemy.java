package com.github.hanyaeger.tutorial.entities.sharky;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class SharkyEnemy extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {
    private static final Size sharkySize = new Size(400, 400);

    public SharkyEnemy(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(1, 90d);
    }

    @Override
    protected void setupEntities() {
        addEntity(createSprite());
        addEntity(createHitBox());
    }

    private SpriteEntity createSprite() {
        return new Sprite(sharkySize);
    }

    private YaegerEntity createHitBox() {
        return new HitBox(new Coordinate2D(sharkySize.width() - 100, 125));
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(0);
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
    }
}
