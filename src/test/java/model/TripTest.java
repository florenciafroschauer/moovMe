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
public class TripTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Trip.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void setDiscount() {
    }

    @Test
    public void setToHandOver() {
    }

    @Test
    public void setTripTime() {
    }

    @Test
    public void calculateScore() {
    }

    @Test
    public void getClient() {
    }

    @Test
    public void getAsset() {
    }

    @Test
    public void getZone() {
    }

    @Test
    public void getTripTime() {
    }

    @Test
    public void getDiscount() {
    }

    @Test
    public void getTerminal() {
    }

    @Test
    public void getTariff() {
    }
}
