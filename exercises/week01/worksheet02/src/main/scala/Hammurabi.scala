/**
  * Created by pabloren on 29/01/2017.
  */

object Hammurabi {

  def main(args: Array[String]): Unit = {

    def printIntroductoryMessage() {
      println(
        """Congratulations, you are the newest ruler of ancient Samaria, elected
             for a ten year term of office. Your duties are to dispense food, direct
             farming, and buy and sell land as needed to support your people. Watch
             out for rat infestations and the plague! Grain is the general currency,
             measured in bushels. The following will help you in your decisions:
               * Each person needs at least 20 bushels of grain per year to survive.
               * Each person can farm at most 10 acres of land.
               * It takes 2 bushels of grain to farm an acre of land.
               * The market price for land fluctuates yearly.
             Rule wisely and you will be showered with appreciation at the end of
             your term. Rule poorly and you will be kicked out of office!""")
    }

    def hammurabi() {
      import scala.util.Random
      var starved = 0
      // how many people starved
      var immigrants = 5
      // how many people came to the city
      var population = 100
      var harvest = 3000
      // total bushels harvested
      var bushelsPerAcre = 3
      // amount harvested for each acre planted
      var rats_ate = 200
      // bushels destroyed by rats
      var bushelsInStorage = 2800
      var acresOwned = 1000
      var pricePerAcre = 19
      // each acre costs this many bushels
      var plagueDeaths = 0

      printIntroductoryMessage()

      for (year <- 1 to 10) {

        println(
          """			O great Hammurabi!
          You are in year """ + year +
            """ of your ten year rule.
          In the previous year """ + starved +
            """ people starved to death.
          In the previous year """ + immigrants +
            """ people entered the kingdom.
          The population is now """ + population +
            """.
          We harvested """ + harvest +
            """ bushels at 3 bushels per acre.
          Rats destroyed """ + rats_ate +
            """ bushels, leaving """ +
            year +
            """ bushels in storage.
          The city owns """ + acresOwned +
            """ acres of land.
          Land is currently worth 19 bushels per acre.
          There were """ + plagueDeaths +
            """ deaths from the plague. """)

        var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
        acresOwned = acresOwned + acresToBuy

        if (acresToBuy == 0) {
          var landToSell = askHowMuchLandToSell(acresOwned)
          acresOwned = acresOwned + landToSell
        }

        var grainToFeed = askHowMuchGrainToFeed(bushelsInStorage)
        if (grainToFeed < (population * 20)) {
          println("O Great Hammurabi, some people have starved!\n")
          starved = (grainToFeed - (population * 20)) / 20
          if ((starved * 100 / population) > 45) {
            println("O Great Hammurabi, your empire has crumbled!\n")
            System.exit(1)
          }
        }

        var acresToPlant = askHowManyAcresToPlant(acresOwned)
        bushelsPerAcre = bushelsPerAcre + (bushelsPerAcre * acresToPlant)

        //if there is a plague

        if (Random.nextInt(100) > 15) {
          println("O Great Hammurabi, we have a plague!\n")
          population = population / 2
        }

      }

    }

    def askHowMuchLandToBuy(bushels: Int, price: Int) = {
      var acresToBuy = readInt("How many acres will you buy?\n")
      while (acresToBuy < 0 || acresToBuy * price > bushels) {
        println("O Great Hammurabi, we have but " + bushels + " bushels of grain!\n")
        acresToBuy = readInt("How many acres will you buy?\n")
      }
      acresToBuy
    }

    def askHowMuchLandToSell(land: Int) = {
      var acresToSell = readInt("How many acres will you sell?\n")
      while (acresToSell < 0 || acresToSell > land) {
        println("O Great Hammurabi, we have but " + land + " acres of land!\n")
        acresToSell = readInt("How many acres will you sell?\n")
      }
      acresToSell
    }

    def askHowMuchGrainToFeed(bushels: Int) = {
      var grainToFeed = readInt("How many bushels do you want to feed to the people?\n")
      while (grainToFeed < 0 || grainToFeed > bushels) {
        println("O Great Hammurabi, we have but " + bushels + " bushels in storage!\n")
        grainToFeed = readInt("How many bushels do you want to feed to the people?\n ")
      }
      grainToFeed
    }

    def askHowManyAcresToPlant(acres: Int) = {
      var acresToPlant = readInt("How many acres do you want to plant?\n")
      while (acresToPlant < 0 || acresToPlant > acres) {
        println("O Great Hammurabi, we have but " + acres + " acres owned!\n")
        acresToPlant = readInt("How many acres do you want to plant?\n")
      }
      acresToPlant
    }

    def readInt(message: String): Int = {
      try {
        readLine(message).toInt
      } catch {
        case _: Throwable =>
          println("That’s not an integer. Please enter an integer.")
          readInt(message)
      }
    }

    hammurabi()
  }
}
