package Builder;

class House
{
    private String fundament;
    private String wall;
    private String windows;
    private String doors;
    private String floor;

    //setters for fields of House class


    public void setFundament(String fundament) {
        this.fundament = fundament;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setWindows(String windows) {
        this.windows = windows;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}


interface HouseBuilder //interface Builder for our House, something like a commander which will build house
{

    public void buildFundament(); //method for build fundament

    public void buildWall(); //method for build wall

    public void buildWindows(); //method for build roof

    public void buildDoors(); //method for build doors

    public void buildFloor(); //method for build floor

    public House getResult(); //get the result of constructing house
}

class TreeHouseBuilder implements HouseBuilder //TreeHouseBuilder, so he is worker for building homes of tree
{
    private House house; //aggregation relationship

    public TreeHouseBuilder()
    {
        this.house = new House();
    } //constructor of class which will calling a constructor of House

    @Override
    public void buildFundament()
    {
        house.setFundament("Tree fundament built");
    } //building tree fundament

    @Override
    public void buildWall()
    {
        house.setWall("Tree wall built");
    } //building tree wall

    @Override
    public void buildWindows()
    {
        house.setWindows("Tree windows built");
    } //building tree roof

    @Override
    public void buildDoors()
    {
        house.setDoors("Tree doors built");
    } //build tree doors

    @Override
    public void buildFloor() {
        house.setFloor("Tree floor built");
    } //build tree floor

    public House getResult()
    {
        return this.house;
    } //get result (instance of House)
}

class BungalowHouseBuilder implements HouseBuilder
{
    private House house;

    public BungalowHouseBuilder()
    {
        this.house = new House(); //creating an object of instance
    }

    @Override
    public void buildFundament()
    {
        house.setFundament("Bungalow fundament built");
    } //building bungalow fundament

    @Override
    public void buildWall()
    {
        house.setWall("Bungalow wall built");
    } //building bungalow wall

    @Override
    public void buildWindows()
    {
        house.setWindows("Bungalow windows built");
    } //building bungalow roof

    @Override
    public void buildDoors()
    {
        house.setDoors("Tree doors built");
    } //build bungalow doors

    @Override
    public void buildFloor() {
        house.setFloor("Tree floor built");
    } //build bungalow floor

    public House getResult()
    {
        return this.house;
    } //get result (instance of House)

}

class BuildingEngineer
{

    private HouseBuilder builder; //Building Engineer will have HouseBuilder instance

    public BuildingEngineer(HouseBuilder builder)  //constructor have parameter as builder
    {
        this.builder = builder;
    }

    public void constructHouse() //method which will construct our chosen type of house
    {
        this.builder.buildFundament();
        this.builder.buildWall();
        this.builder.buildWindows();
        this.builder.buildDoors();
        this.builder.buildFloor();
    }

    public House getHouse() //get house give us, house has built
    {
        return builder.getResult();
    }
}

class Builder
{
    public static void main(String[] args)
    {
        HouseBuilder houseBuilder = new TreeHouseBuilder(); //instance of HouseBuilder call constructor of TreeHouseBuilder
        BuildingEngineer engineer = new BuildingEngineer(houseBuilder); //transfer to constructor of BuildingEngineer

        engineer.constructHouse(); //call constructHouse(), it will construct house of material we have declared
        House house = engineer.getHouse(); //get our house
        System.out.println(house); //get the result of house
    }
}