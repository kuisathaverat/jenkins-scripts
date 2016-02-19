/*** BEGIN META {
 "name" : "List executed Jobs",
 "comment" : "List Jobs executed in a range of time",
 "core": "1.609",
 "authors" : [
 { name : "Kuisathaverat" }
 ]
 } END META**/


 /*** BEGIN META {
  "name" : "List executed Jobs",
  "comment" : "List Jobs executed in a range of time",
  "core": "1.609",
  "authors" : [
  { name : "Kuisathaverat" }
  ]
  } END META**/


 import hudson.model.*
 import java.util.Date

 hudson = Hudson.instance

 int count = 0
 Date now = new Date()
 Calendar after = Calendar.getInstance()
 Calendar before = Calendar.getInstance()
 //set(int year, int month, int date, int hourOfDay, int minute,int second)
 after.set(2016,1,5)
 before.set(2016,1,23)
 println "Jobs executed between " + after.getTime() + " - " + before.getTime()

 for (job in hudson.projects) {
   for(Run run in job.getBuilds()){
         if (run.getTimestamp()?.before(before) && run.getTimestamp()?.after(after)) {
                 println "" + run.getResult() + " " + job.name + " " + job.getLastBuild().getTime()
         }
   }
 }
