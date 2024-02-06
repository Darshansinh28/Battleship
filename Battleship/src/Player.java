public class Player {
    protected Ship[] ship;
    protected Grenade[] grenade;

    Player() {
        this.ship = new Ship[6];

        for (int i = 0; i < 6; i++) {
            ship[i] = new Ship();
        }

        this.grenade = new Grenade[4];
        for (int i = 0; i < 4; i++) {
            grenade[i] = new Grenade();
        }
    }
    public Ship getShip(int x) {

        return this.ship[x];
    }

    public Grenade getGrenade(int x) {

        return this.grenade[x];
    }



}
