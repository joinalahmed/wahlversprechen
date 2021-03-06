package controllers

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._
import helpers.WithTestDatabase

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationSpec extends Specification with WithTestDatabase  {
  "Application" should {
    
    "send 404 on a bad request" in {
        route(FakeRequest(GET, "/boum")) must beNone        
    }

    "render the index page" in {
        val home = route(FakeRequest(GET, "/")).get
        
        (status(home) must equalTo(OK)) and
        (contentType(home) must beSome.which(_ == "text/html"))
        (contentAsString(home) must contain ("wahlversprechen"))
    }
  }
}