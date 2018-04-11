$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Phase2/RemoveGroupUsers.feature");
formatter.feature({
  "line": 2,
  "name": "Remove users from the group from edit view",
  "description": "As an Admin user\r\nI should be able to remove a user associated with a group",
  "id": "remove-users-from-the-group-from-edit-view",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "Remove users from group",
  "description": "",
  "id": "remove-users-from-the-group-from-edit-view;remove-users-from-group",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@remove"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "Iam on Landing Page as an Admin user",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "Iam on the Admin menu",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I remove a user from a group",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the user should be removed from the group",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonUtil.iam_on_landing_page()"
});
formatter.result({
  "duration": 38419108422,
  "status": "passed"
});
formatter.match({
  "location": "CommonUtil.Admin_menu()"
});
formatter.result({
  "duration": 26312853480,
  "status": "passed"
});
formatter.match({
  "location": "RemoveGroupUserTest.iRemoveAUserFromAGroup()"
});
formatter.result({
  "duration": 55566204884,
  "status": "passed"
});
formatter.match({
  "location": "RemoveGroupUserTest.theUserShouldBeRemovedFromTheGroup()"
});
formatter.result({
  "duration": 52462307762,
  "status": "passed"
});
formatter.after({
  "duration": 260321,
  "status": "passed"
});
});