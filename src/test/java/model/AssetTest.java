package model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class AssetTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Asset.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void getKey() {
    }

    @Test
    public void getTariff() {
    }

    @Test
    public void setScore() {
    }

    @Test
    public void getZone() {
    }

    @Test
    public void getType() {
    }

    @Test
    public void getDiscount() {
    }

    @Test
    public void getLot() {
    }

    @Test
    public void givePoints() {
    }
}
