package org.fundacionjala.pivotal.cucumber.stepdefinition.workspace;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.api.Mapper;
import org.fundacionjala.pivotal.cucumber.hooks.WorkspaceHooks;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel
 */

public class WorkspaceAssert {

    private WorkspaceStepDef workspaceStepDef;

    private WorkspaceHooks workspaceHooks;

    private static final String SAVED_MESSAGE = "Changes saved.";

    public WorkspaceAssert (WorkspaceStepDef workspaceStepDef, WorkspaceHooks workspaceHooks) {
        this.workspaceStepDef = workspaceStepDef;
        this.workspaceHooks = workspaceHooks;
    }

    @And("^the display name equals to (.*)$")
    public void theDisplayNameEqualsTo (String workspaceName) {
        assertEquals (workspaceName, workspaceStepDef.getWorkspace ().getToolBarWorkspace ().getWorkspaceNameText ());
        workspaceHooks.DeleteWorkspace();
    }

    @Then("^A message displayed: (.*)$")
    public void aMessageDisplayedWorkspaceNameCanTBeBlank (String message) {
        assertEquals (message, workspaceStepDef.getCreateWorkspace ().getMessageWorkspaceNameEmpty ());
        workspaceStepDef.getCreateWorkspace ().clickCancelCreateWorkspaceLink ();
        workspaceHooks.DeleteWorkspace();
    }

    @Then("^I expect a workspace with the (.*) project name$")
    public void iExpectAWorkspaceWithTheProjectSelected (String nameProject) {
        String FinalNameProject = Mapper.getPropertiesProject(nameProject);
        assertEquals (FinalNameProject.toUpperCase (), workspaceStepDef.getWorkspace ().getProjectIntoWorkspaceNameText ());
        workspaceHooks.DeleteWorkspace();
    }

    @Then("^I expect the next message: (.*)$")
    public void iExpectTheNextMessageWorkspaceWasSuccessfullyDeleted (String message) {
        if (SAVED_MESSAGE.equalsIgnoreCase (message)) {
            assertEquals (message, workspaceStepDef.getSettingWorkspace ().getMessageChangesWorkspace ());
        } else {
            String expectMessage = Mapper.getPropertiesProject(message);
            assertEquals (expectMessage, workspaceStepDef.getDashboard ().getMessageDeleteWorkspace ());
        }
    }
}