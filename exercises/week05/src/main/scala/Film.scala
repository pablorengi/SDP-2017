package films

/**
  * Created by pabloren on 19/02/2017.
  */
case class Film(name: String, yearOfRelease: Int, imdbRating: Double,
           director: Director) {

  def directorsAge(): Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy(aDirector: Director): Boolean = {
    if (aDirector.==(director)) true
    else false
  }

  def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating,
           director: Director = this.director): Film =
    new Film(name, yearOfRelease, imdbRating, director)
}

object Film {

  def highestRating(film1: Film, film2: Film): Film = {
    if(film1.imdbRating > film2.imdbRating) film1
    else film2
  }

  def oldestDirectorAtTheTime(film1: Film, film2: Film): Director = {
    if(film1.directorsAge > film2.directorsAge) film1.director
    else film2.director
  }
}