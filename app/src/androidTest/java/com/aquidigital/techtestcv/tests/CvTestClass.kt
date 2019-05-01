package com.aquidigital.techtestcv.tests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import com.aquidigital.techtestcv.R
import com.aquidigital.techtestcv.Stub
import com.aquidigital.techtestcv.custommatcher.atPosition
import com.aquidigital.techtestcv.testrule.CvActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CvTestClass {

    @get:Rule
    var rule = CvActivityTestRule()

    @Test
    fun successLoadingCv() {
        rule.launch(Stub.Success)
        verifyScreen()
    }

    private fun verifyScreen() {

        onView(withId(R.id.cv_activity_container))
            .check(matches(isDisplayed()))

        onView(withId(R.id.nameView))
            .check(matches(isDisplayed()))
            .check(matches(withText("Ruairi McGuigan")))

        onView(withId(R.id.jobTitleView))
            .check(matches(isDisplayed()))
            .check(matches(withText("Android Developer (Contract)")))

        onView(withId(R.id.profileView))
            .check(matches(isDisplayed()))
            .check(matches(withText("Experience ranging from working on a number of large commercial banking projects to small in-house initiatives. I have worked within near and offshore teams, delivering aspirational, industry leading, business led solutions on highly innovative, first-to-market products. I pride myself in using considered technologies to turn great ideas into beautiful, engaging digital experiences.")))

        onView(withId(R.id.experienceListView))
            .check(matches(atPosition(0, hasDescendant(withText("Just Eat (Contract)")))))
            .check(matches(atPosition(0, hasDescendant(withText("November 2018 - May 2019")))))
            .check(matches(atPosition(0, hasDescendant(withText("At RBS I worked alongside another Senior Android Developer to setup the foundations of a new payments mobile app...")))))

        onView(withId(R.id.experienceListView))
            .check(matches(atPosition(1, hasDescendant(withText("Clydesdale & Yorkshire Bank Group, (Contract)")))))
            .check(matches(atPosition(1, hasDescendant(withText("November 2017 - May 2018")))))
            .check(matches(atPosition(1, hasDescendant(withText("Working within the Android capability providing spec implementation and support for the Clydesdale Banking Group core mobile banking applications. Responsibilities include: \n" +
                    "\n" +
                    "- Progressing the design of the solution as the requirements and technical landscape changes\n" +
                    "- Identifying, implementing or suggesting changes that improve capability to internal and external customers.")))))
    }
}