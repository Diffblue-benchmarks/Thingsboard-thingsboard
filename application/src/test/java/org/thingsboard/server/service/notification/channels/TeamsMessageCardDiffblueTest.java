package org.thingsboard.server.service.notification.channels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.service.notification.channels.TeamsMessageCard.ActionCard;
import org.thingsboard.server.service.notification.channels.TeamsMessageCard.ActionCard.Action;
import org.thingsboard.server.service.notification.channels.TeamsMessageCard.ActionCard.Input;
import org.thingsboard.server.service.notification.channels.TeamsMessageCard.ActionCard.Input.Choice;
import org.thingsboard.server.service.notification.channels.TeamsMessageCard.ActionCard.Target;
import org.thingsboard.server.service.notification.channels.TeamsMessageCard.Section;
import org.thingsboard.server.service.notification.channels.TeamsMessageCard.Section.Fact;

@ContextConfiguration(classes = {TeamsMessageCard.class})
@ExtendWith(SpringExtension.class)
class TeamsMessageCardDiffblueTest {
  @Autowired private TeamsMessageCard teamsMessageCard;

  /**
   * Test ActionCard {@link ActionCard#equals(Object)}, and {@link ActionCard#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionCard#equals(Object)}
   *   <li>{@link ActionCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.equals(Object)", "int ActionCard.hashCode()"})
  void testActionCardEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ActionCard actionCard = new ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    ActionCard actionCard2 = new ActionCard();
    actionCard2.setActions(new ArrayList<>());
    actionCard2.setInputs(new ArrayList<>());
    actionCard2.setName("Name");
    actionCard2.setTargets(new ArrayList<>());
    actionCard2.setType("Type");

    // Act and Assert
    assertEquals(actionCard, actionCard2);
    int expectedHashCodeResult = actionCard.hashCode();
    assertEquals(expectedHashCodeResult, actionCard2.hashCode());
  }

  /**
   * Test ActionCard {@link ActionCard#equals(Object)}, and {@link ActionCard#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionCard#equals(Object)}
   *   <li>{@link ActionCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.equals(Object)", "int ActionCard.hashCode()"})
  void testActionCardEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ActionCard actionCard = new ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    // Act and Assert
    assertEquals(actionCard, actionCard);
    int expectedHashCodeResult = actionCard.hashCode();
    assertEquals(expectedHashCodeResult, actionCard.hashCode());
  }

  /**
   * Test ActionCard {@link ActionCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.equals(Object)", "int ActionCard.hashCode()"})
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Action> actions = new ArrayList<>();
    actions.add(new Action("Type", "Type", "Type"));

    ActionCard actionCard = new ActionCard();
    actionCard.setActions(actions);
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    ActionCard actionCard2 = new ActionCard();
    actionCard2.setActions(new ArrayList<>());
    actionCard2.setInputs(new ArrayList<>());
    actionCard2.setName("Name");
    actionCard2.setTargets(new ArrayList<>());
    actionCard2.setType("Type");

    // Act and Assert
    assertNotEquals(actionCard, actionCard2);
  }

  /**
   * Test ActionCard {@link ActionCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.equals(Object)", "int ActionCard.hashCode()"})
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    ArrayList<Input> inputs = new ArrayList<>();
    inputs.add(input);

    ActionCard actionCard = new ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(inputs);
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    ActionCard actionCard2 = new ActionCard();
    actionCard2.setActions(new ArrayList<>());
    actionCard2.setInputs(new ArrayList<>());
    actionCard2.setName("Name");
    actionCard2.setTargets(new ArrayList<>());
    actionCard2.setType("Type");

    // Act and Assert
    assertNotEquals(actionCard, actionCard2);
  }

  /**
   * Test ActionCard {@link ActionCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.equals(Object)", "int ActionCard.hashCode()"})
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ActionCard actionCard = new ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Type");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    ActionCard actionCard2 = new ActionCard();
    actionCard2.setActions(new ArrayList<>());
    actionCard2.setInputs(new ArrayList<>());
    actionCard2.setName("Name");
    actionCard2.setTargets(new ArrayList<>());
    actionCard2.setType("Type");

    // Act and Assert
    assertNotEquals(actionCard, actionCard2);
  }

  /**
   * Test ActionCard {@link ActionCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.equals(Object)", "int ActionCard.hashCode()"})
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ActionCard actionCard = new ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName(null);
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    ActionCard actionCard2 = new ActionCard();
    actionCard2.setActions(new ArrayList<>());
    actionCard2.setInputs(new ArrayList<>());
    actionCard2.setName("Name");
    actionCard2.setTargets(new ArrayList<>());
    actionCard2.setType("Type");

    // Act and Assert
    assertNotEquals(actionCard, actionCard2);
  }

  /**
   * Test ActionCard {@link ActionCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.equals(Object)", "int ActionCard.hashCode()"})
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<Target> targets = new ArrayList<>();
    targets.add(new Target("Type", "Type"));

    ActionCard actionCard = new ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(targets);
    actionCard.setType("Type");

    ActionCard actionCard2 = new ActionCard();
    actionCard2.setActions(new ArrayList<>());
    actionCard2.setInputs(new ArrayList<>());
    actionCard2.setName("Name");
    actionCard2.setTargets(new ArrayList<>());
    actionCard2.setType("Type");

    // Act and Assert
    assertNotEquals(actionCard, actionCard2);
  }

  /**
   * Test ActionCard {@link ActionCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.equals(Object)", "int ActionCard.hashCode()"})
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ActionCard actionCard = new ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Name");

    ActionCard actionCard2 = new ActionCard();
    actionCard2.setActions(new ArrayList<>());
    actionCard2.setInputs(new ArrayList<>());
    actionCard2.setName("Name");
    actionCard2.setTargets(new ArrayList<>());
    actionCard2.setType("Type");

    // Act and Assert
    assertNotEquals(actionCard, actionCard2);
  }

  /**
   * Test ActionCard {@link ActionCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.equals(Object)", "int ActionCard.hashCode()"})
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ActionCard actionCard = new ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType(null);

    ActionCard actionCard2 = new ActionCard();
    actionCard2.setActions(new ArrayList<>());
    actionCard2.setInputs(new ArrayList<>());
    actionCard2.setName("Name");
    actionCard2.setTargets(new ArrayList<>());
    actionCard2.setType("Type");

    // Act and Assert
    assertNotEquals(actionCard, actionCard2);
  }

  /**
   * Test ActionCard {@link ActionCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.equals(Object)", "int ActionCard.hashCode()"})
  void testActionCardEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ActionCard actionCard = new ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    // Act and Assert
    assertNotEquals(actionCard, null);
  }

  /**
   * Test ActionCard {@link ActionCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.equals(Object)", "int ActionCard.hashCode()"})
  void testActionCardEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ActionCard actionCard = new ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    // Act and Assert
    assertNotEquals(actionCard, "Different type to ActionCard");
  }

  /**
   * Test ActionCard getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ActionCard}
   *   <li>{@link ActionCard#setActions(List)}
   *   <li>{@link ActionCard#setInputs(List)}
   *   <li>{@link ActionCard#setName(String)}
   *   <li>{@link ActionCard#setTargets(List)}
   *   <li>{@link ActionCard#setType(String)}
   *   <li>{@link ActionCard#toString()}
   *   <li>{@link ActionCard#getActions()}
   *   <li>{@link ActionCard#getInputs()}
   *   <li>{@link ActionCard#getName()}
   *   <li>{@link ActionCard#getTargets()}
   *   <li>{@link ActionCard#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ActionCard.<init>()",
    "List ActionCard.getActions()",
    "List ActionCard.getInputs()",
    "String ActionCard.getName()",
    "List ActionCard.getTargets()",
    "String ActionCard.getType()",
    "void ActionCard.setActions(List)",
    "void ActionCard.setInputs(List)",
    "void ActionCard.setName(String)",
    "void ActionCard.setTargets(List)",
    "void ActionCard.setType(String)",
    "String ActionCard.toString()"
  })
  void testActionCardGettersAndSetters() {
    // Arrange and Act
    ActionCard actualActionCard = new ActionCard();
    ArrayList<Action> actions = new ArrayList<>();
    actualActionCard.setActions(actions);
    ArrayList<Input> inputs = new ArrayList<>();
    actualActionCard.setInputs(inputs);
    actualActionCard.setName("Name");
    ArrayList<Target> targets = new ArrayList<>();
    actualActionCard.setTargets(targets);
    actualActionCard.setType("Type");
    String actualToStringResult = actualActionCard.toString();
    List<Action> actualActions = actualActionCard.getActions();
    List<Input> actualInputs = actualActionCard.getInputs();
    String actualName = actualActionCard.getName();
    List<Target> actualTargets = actualActionCard.getTargets();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(
        "TeamsMessageCard.ActionCard(type=Type, name=Name, inputs=[], actions=[], targets=[])",
        actualToStringResult);
    assertEquals("Type", actualActionCard.getType());
    assertTrue(actualActions.isEmpty());
    assertTrue(actualInputs.isEmpty());
    assertTrue(actualTargets.isEmpty());
    assertSame(actions, actualActions);
    assertSame(inputs, actualInputs);
    assertSame(targets, actualTargets);
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}, and {@link Action#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Action#equals(Object)}
   *   <li>{@link Action#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Action equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Action action = new Action("Type", "Name", "Target");
    Action action2 = new Action("Type", "Name", "Target");

    // Act and Assert
    assertEquals(action, action2);
    int expectedHashCodeResult = action.hashCode();
    assertEquals(expectedHashCodeResult, action2.hashCode());
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}, and {@link Action#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Action#equals(Object)}
   *   <li>{@link Action#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Action equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Action action = new Action(null, "Name", "Target");
    Action action2 = new Action(null, "Name", "Target");

    // Act and Assert
    assertEquals(action, action2);
    int expectedHashCodeResult = action.hashCode();
    assertEquals(expectedHashCodeResult, action2.hashCode());
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}, and {@link Action#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Action#equals(Object)}
   *   <li>{@link Action#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Action equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Action action = new Action("Type", null, "Target");
    Action action2 = new Action("Type", null, "Target");

    // Act and Assert
    assertEquals(action, action2);
    int expectedHashCodeResult = action.hashCode();
    assertEquals(expectedHashCodeResult, action2.hashCode());
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}, and {@link Action#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Action#equals(Object)}
   *   <li>{@link Action#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Action equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Action action = new Action("Type", "Name", null);
    Action action2 = new Action("Type", "Name", null);

    // Act and Assert
    assertEquals(action, action2);
    int expectedHashCodeResult = action.hashCode();
    assertEquals(expectedHashCodeResult, action2.hashCode());
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}, and {@link Action#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Action#equals(Object)}
   *   <li>{@link Action#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Action equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Action action = new Action("Type", "Name", "Target");

    // Act and Assert
    assertEquals(action, action);
    int expectedHashCodeResult = action.hashCode();
    assertEquals(expectedHashCodeResult, action.hashCode());
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Action#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Action equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Action action = new Action("Name", "Name", "Target");

    // Act and Assert
    assertNotEquals(action, new Action("Type", "Name", "Target"));
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Action#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Action equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Action action = new Action(null, "Name", "Target");

    // Act and Assert
    assertNotEquals(action, new Action("Type", "Name", "Target"));
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Action#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Action equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Action action = new Action("Type", "Type", "Target");

    // Act and Assert
    assertNotEquals(action, new Action("Type", "Name", "Target"));
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Action#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Action equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Action action = new Action("Type", null, "Target");

    // Act and Assert
    assertNotEquals(action, new Action("Type", "Name", "Target"));
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Action#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Action equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Action action = new Action("Type", "Name", "Type");

    // Act and Assert
    assertNotEquals(action, new Action("Type", "Name", "Target"));
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Action#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Action equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Action action = new Action("Type", "Name", null);

    // Act and Assert
    assertNotEquals(action, new Action("Type", "Name", "Target"));
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Action#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Action("Type", "Name", "Target"), null);
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Action#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Action equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Action.equals(Object)", "int Action.hashCode()"})
  void testActionCard_ActionEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Action("Type", "Name", "Target"), "Different type to Action");
  }

  /**
   * Test ActionCard_Action getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Action#Action(String, String, String)}
   *   <li>{@link Action#toString()}
   *   <li>{@link Action#getName()}
   *   <li>{@link Action#getTarget()}
   *   <li>{@link Action#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Action getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void Action.<init>(String, String, String)",
    "String Action.getName()",
    "String Action.getTarget()",
    "String Action.getType()",
    "String Action.toString()"
  })
  void testActionCard_ActionGettersAndSetters() {
    // Arrange and Act
    Action actualAction = new Action("Type", "Name", "Target");
    String actualToStringResult = actualAction.toString();
    String actualName = actualAction.getName();
    String actualTarget = actualAction.getTarget();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Target", actualTarget);
    assertEquals(
        "TeamsMessageCard.ActionCard.Action(type=Type, name=Name, target=Target)",
        actualToStringResult);
    assertEquals("Type", actualAction.getType());
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}, and {@link
   * ActionCard.Input#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionCard.Input#equals(Object)}
   *   <li>{@link ActionCard.Input#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    Input input2 = new Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertEquals(input, input2);
    int expectedHashCodeResult = input.hashCode();
    assertEquals(expectedHashCodeResult, input2.hashCode());
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}, and {@link
   * ActionCard.Input#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionCard.Input#equals(Object)}
   *   <li>{@link ActionCard.Input#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Input input = new Input();
    input.setId(null);
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    Input input2 = new Input();
    input2.setId(null);
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertEquals(input, input2);
    int expectedHashCodeResult = input.hashCode();
    assertEquals(expectedHashCodeResult, input2.hashCode());
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}, and {@link
   * ActionCard.Input#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionCard.Input#equals(Object)}
   *   <li>{@link ActionCard.Input#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle(null);
    input.setType("Type");

    Input input2 = new Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle(null);
    input2.setType("Type");

    // Act and Assert
    assertEquals(input, input2);
    int expectedHashCodeResult = input.hashCode();
    assertEquals(expectedHashCodeResult, input2.hashCode());
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}, and {@link
   * ActionCard.Input#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionCard.Input#equals(Object)}
   *   <li>{@link ActionCard.Input#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType(null);

    Input input2 = new Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType(null);

    // Act and Assert
    assertEquals(input, input2);
    int expectedHashCodeResult = input.hashCode();
    assertEquals(expectedHashCodeResult, input2.hashCode());
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}, and {@link
   * ActionCard.Input#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionCard.Input#equals(Object)}
   *   <li>{@link ActionCard.Input#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    // Act and Assert
    assertEquals(input, input);
    int expectedHashCodeResult = input.hashCode();
    assertEquals(expectedHashCodeResult, input.hashCode());
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Input input = new Input();
    input.setId("Type");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    Input input2 = new Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Input input = new Input();
    input.setId(null);
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    Input input2 = new Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(false);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    Input input2 = new Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(false);
    input.setTitle("Dr");
    input.setType("Type");

    Input input2 = new Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Mr");
    input.setType("Type");

    Input input2 = new Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle(null);
    input.setType("Type");

    Input input2 = new Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("42");

    Input input2 = new Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType(null);

    Input input2 = new Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    // Act and Assert
    assertNotEquals(input, null);
  }

  /**
   * Test ActionCard_Input {@link ActionCard.Input#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionCard.Input.equals(Object)", "int ActionCard.Input.hashCode()"})
  void testActionCard_InputEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Input input = new Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    // Act and Assert
    assertNotEquals(input, "Different type to Input");
  }

  /**
   * Test ActionCard_Input getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ActionCard.Input}
   *   <li>{@link ActionCard.Input#setId(String)}
   *   <li>{@link ActionCard.Input#setMultiSelect(boolean)}
   *   <li>{@link ActionCard.Input#setMultiple(boolean)}
   *   <li>{@link ActionCard.Input#setTitle(String)}
   *   <li>{@link ActionCard.Input#setType(String)}
   *   <li>{@link ActionCard.Input#toString()}
   *   <li>{@link ActionCard.Input#getId()}
   *   <li>{@link ActionCard.Input#getTitle()}
   *   <li>{@link ActionCard.Input#getType()}
   *   <li>{@link ActionCard.Input#isMultiSelect()}
   *   <li>{@link ActionCard.Input#isMultiple()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ActionCard.Input.<init>()",
    "String ActionCard.Input.getId()",
    "String ActionCard.Input.getTitle()",
    "String ActionCard.Input.getType()",
    "boolean ActionCard.Input.isMultiSelect()",
    "boolean ActionCard.Input.isMultiple()",
    "void ActionCard.Input.setId(String)",
    "void ActionCard.Input.setMultiSelect(boolean)",
    "void ActionCard.Input.setMultiple(boolean)",
    "void ActionCard.Input.setTitle(String)",
    "void ActionCard.Input.setType(String)",
    "String ActionCard.Input.toString()"
  })
  void testActionCard_InputGettersAndSetters() {
    // Arrange and Act
    Input actualInput = new Input();
    actualInput.setId("42");
    actualInput.setMultiSelect(true);
    actualInput.setMultiple(true);
    actualInput.setTitle("Dr");
    actualInput.setType("Type");
    String actualToStringResult = actualInput.toString();
    String actualId = actualInput.getId();
    String actualTitle = actualInput.getTitle();
    String actualType = actualInput.getType();
    boolean actualIsMultiSelectResult = actualInput.isMultiSelect();

    // Assert
    assertEquals("42", actualId);
    assertEquals("Dr", actualTitle);
    assertEquals(
        "TeamsMessageCard.ActionCard.Input(type=Type, id=42, isMultiple=true, title=Dr, isMultiSelect=true)",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertTrue(actualIsMultiSelectResult);
    assertTrue(actualInput.isMultiple());
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}, and {@link Choice#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Choice#equals(Object)}
   *   <li>{@link Choice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input_Choice equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Choice.equals(Object)", "int Choice.hashCode()"})
  void testActionCard_Input_ChoiceEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Choice choice = new Choice("Display", "42");
    Choice choice2 = new Choice("Display", "42");

    // Act and Assert
    assertEquals(choice, choice2);
    int expectedHashCodeResult = choice.hashCode();
    assertEquals(expectedHashCodeResult, choice2.hashCode());
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}, and {@link Choice#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Choice#equals(Object)}
   *   <li>{@link Choice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input_Choice equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Choice.equals(Object)", "int Choice.hashCode()"})
  void testActionCard_Input_ChoiceEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Choice choice = new Choice(null, "42");
    Choice choice2 = new Choice(null, "42");

    // Act and Assert
    assertEquals(choice, choice2);
    int expectedHashCodeResult = choice.hashCode();
    assertEquals(expectedHashCodeResult, choice2.hashCode());
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}, and {@link Choice#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Choice#equals(Object)}
   *   <li>{@link Choice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input_Choice equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Choice.equals(Object)", "int Choice.hashCode()"})
  void testActionCard_Input_ChoiceEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Choice choice = new Choice("Display", null);
    Choice choice2 = new Choice("Display", null);

    // Act and Assert
    assertEquals(choice, choice2);
    int expectedHashCodeResult = choice.hashCode();
    assertEquals(expectedHashCodeResult, choice2.hashCode());
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}, and {@link Choice#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Choice#equals(Object)}
   *   <li>{@link Choice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input_Choice equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Choice.equals(Object)", "int Choice.hashCode()"})
  void testActionCard_Input_ChoiceEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Choice choice = new Choice("Display", "42");

    // Act and Assert
    assertEquals(choice, choice);
    int expectedHashCodeResult = choice.hashCode();
    assertEquals(expectedHashCodeResult, choice.hashCode());
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Choice#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input_Choice equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Choice.equals(Object)", "int Choice.hashCode()"})
  void testActionCard_Input_ChoiceEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Choice choice = new Choice("42", "42");

    // Act and Assert
    assertNotEquals(choice, new Choice("Display", "42"));
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Choice#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input_Choice equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Choice.equals(Object)", "int Choice.hashCode()"})
  void testActionCard_Input_ChoiceEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Choice choice = new Choice(null, "42");

    // Act and Assert
    assertNotEquals(choice, new Choice("Display", "42"));
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Choice#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input_Choice equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Choice.equals(Object)", "int Choice.hashCode()"})
  void testActionCard_Input_ChoiceEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Choice choice = new Choice("Display", "Display");

    // Act and Assert
    assertNotEquals(choice, new Choice("Display", "42"));
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Choice#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input_Choice equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Choice.equals(Object)", "int Choice.hashCode()"})
  void testActionCard_Input_ChoiceEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Choice choice = new Choice("Display", null);

    // Act and Assert
    assertNotEquals(choice, new Choice("Display", "42"));
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Choice#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input_Choice equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Choice.equals(Object)", "int Choice.hashCode()"})
  void testActionCard_Input_ChoiceEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Choice("Display", "42"), null);
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Choice#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Input_Choice equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Choice.equals(Object)", "int Choice.hashCode()"})
  void testActionCard_Input_ChoiceEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Choice("Display", "42"), "Different type to Choice");
  }

  /**
   * Test ActionCard_Input_Choice getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Choice#Choice(String, String)}
   *   <li>{@link Choice#toString()}
   *   <li>{@link Choice#getDisplay()}
   *   <li>{@link Choice#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input_Choice getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void Choice.<init>(String, String)",
    "String Choice.getDisplay()",
    "String Choice.getValue()",
    "String Choice.toString()"
  })
  void testActionCard_Input_ChoiceGettersAndSetters() {
    // Arrange and Act
    Choice actualChoice = new Choice("Display", "42");
    String actualToStringResult = actualChoice.toString();
    String actualDisplay = actualChoice.getDisplay();

    // Assert
    assertEquals("42", actualChoice.getValue());
    assertEquals("Display", actualDisplay);
    assertEquals(
        "TeamsMessageCard.ActionCard.Input.Choice(display=Display, value=42)",
        actualToStringResult);
  }

  /**
   * Test ActionCard_Target {@link ActionCard.Target#equals(Object)}, and {@link
   * ActionCard.Target#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionCard.Target#equals(Object)}
   *   <li>{@link ActionCard.Target#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Target equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ActionCard.Target.equals(Object)",
    "int ActionCard.Target.hashCode()"
  })
  void testActionCard_TargetEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Target target = new Target("Os", "Uri");
    Target target2 = new Target("Os", "Uri");

    // Act and Assert
    assertEquals(target, target2);
    int expectedHashCodeResult = target.hashCode();
    assertEquals(expectedHashCodeResult, target2.hashCode());
  }

  /**
   * Test ActionCard_Target {@link ActionCard.Target#equals(Object)}, and {@link
   * ActionCard.Target#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionCard.Target#equals(Object)}
   *   <li>{@link ActionCard.Target#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Target equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ActionCard.Target.equals(Object)",
    "int ActionCard.Target.hashCode()"
  })
  void testActionCard_TargetEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Target target = new Target(null, "Uri");
    Target target2 = new Target(null, "Uri");

    // Act and Assert
    assertEquals(target, target2);
    int expectedHashCodeResult = target.hashCode();
    assertEquals(expectedHashCodeResult, target2.hashCode());
  }

  /**
   * Test ActionCard_Target {@link ActionCard.Target#equals(Object)}, and {@link
   * ActionCard.Target#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionCard.Target#equals(Object)}
   *   <li>{@link ActionCard.Target#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Target equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ActionCard.Target.equals(Object)",
    "int ActionCard.Target.hashCode()"
  })
  void testActionCard_TargetEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Target target = new Target("Os", null);
    Target target2 = new Target("Os", null);

    // Act and Assert
    assertEquals(target, target2);
    int expectedHashCodeResult = target.hashCode();
    assertEquals(expectedHashCodeResult, target2.hashCode());
  }

  /**
   * Test ActionCard_Target {@link ActionCard.Target#equals(Object)}, and {@link
   * ActionCard.Target#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionCard.Target#equals(Object)}
   *   <li>{@link ActionCard.Target#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionCard_Target equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ActionCard.Target.equals(Object)",
    "int ActionCard.Target.hashCode()"
  })
  void testActionCard_TargetEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Target target = new Target("Os", "Uri");

    // Act and Assert
    assertEquals(target, target);
    int expectedHashCodeResult = target.hashCode();
    assertEquals(expectedHashCodeResult, target.hashCode());
  }

  /**
   * Test ActionCard_Target {@link ActionCard.Target#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Target#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Target equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ActionCard.Target.equals(Object)",
    "int ActionCard.Target.hashCode()"
  })
  void testActionCard_TargetEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Target target = new Target("Uri", "Uri");

    // Act and Assert
    assertNotEquals(target, new Target("Os", "Uri"));
  }

  /**
   * Test ActionCard_Target {@link ActionCard.Target#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Target#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Target equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ActionCard.Target.equals(Object)",
    "int ActionCard.Target.hashCode()"
  })
  void testActionCard_TargetEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Target target = new Target(null, "Uri");

    // Act and Assert
    assertNotEquals(target, new Target("Os", "Uri"));
  }

  /**
   * Test ActionCard_Target {@link ActionCard.Target#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Target#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Target equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ActionCard.Target.equals(Object)",
    "int ActionCard.Target.hashCode()"
  })
  void testActionCard_TargetEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Target target = new Target("Os", "Os");

    // Act and Assert
    assertNotEquals(target, new Target("Os", "Uri"));
  }

  /**
   * Test ActionCard_Target {@link ActionCard.Target#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Target#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Target equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ActionCard.Target.equals(Object)",
    "int ActionCard.Target.hashCode()"
  })
  void testActionCard_TargetEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Target target = new Target("Os", null);

    // Act and Assert
    assertNotEquals(target, new Target("Os", "Uri"));
  }

  /**
   * Test ActionCard_Target {@link ActionCard.Target#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Target#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Target equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ActionCard.Target.equals(Object)",
    "int ActionCard.Target.hashCode()"
  })
  void testActionCard_TargetEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Target("Os", "Uri"), null);
  }

  /**
   * Test ActionCard_Target {@link ActionCard.Target#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionCard.Target#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ActionCard_Target equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ActionCard.Target.equals(Object)",
    "int ActionCard.Target.hashCode()"
  })
  void testActionCard_TargetEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Target("Os", "Uri"), "Different type to Target");
  }

  /**
   * Test ActionCard_Target getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionCard.Target#Target(String, String)}
   *   <li>{@link ActionCard.Target#toString()}
   *   <li>{@link ActionCard.Target#getOs()}
   *   <li>{@link ActionCard.Target#getUri()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Target getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ActionCard.Target.<init>(String, String)",
    "String ActionCard.Target.getOs()",
    "String ActionCard.Target.getUri()",
    "String ActionCard.Target.toString()"
  })
  void testActionCard_TargetGettersAndSetters() {
    // Arrange and Act
    Target actualTarget = new Target("Os", "Uri");
    String actualToStringResult = actualTarget.toString();
    String actualOs = actualTarget.getOs();

    // Assert
    assertEquals("Os", actualOs);
    assertEquals("TeamsMessageCard.ActionCard.Target(os=Os, uri=Uri)", actualToStringResult);
    assertEquals("Uri", actualTarget.getUri());
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}, and {@link TeamsMessageCard#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsMessageCard#equals(Object)}
   *   <li>{@link TeamsMessageCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsMessageCard.equals(Object)", "int TeamsMessageCard.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsMessageCard teamsMessageCard = new TeamsMessageCard();
    teamsMessageCard.setPotentialAction(new ArrayList<>());
    teamsMessageCard.setSections(new ArrayList<>());
    teamsMessageCard.setSummary("Summary");
    teamsMessageCard.setText("Text");
    teamsMessageCard.setThemeColor("Theme Color");

    TeamsMessageCard teamsMessageCard2 = new TeamsMessageCard();
    teamsMessageCard2.setPotentialAction(new ArrayList<>());
    teamsMessageCard2.setSections(new ArrayList<>());
    teamsMessageCard2.setSummary("Summary");
    teamsMessageCard2.setText("Text");
    teamsMessageCard2.setThemeColor("Theme Color");

    // Act and Assert
    assertEquals(teamsMessageCard, teamsMessageCard2);
    int expectedHashCodeResult = teamsMessageCard.hashCode();
    assertEquals(expectedHashCodeResult, teamsMessageCard2.hashCode());
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}, and {@link TeamsMessageCard#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsMessageCard#equals(Object)}
   *   <li>{@link TeamsMessageCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsMessageCard.equals(Object)", "int TeamsMessageCard.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsMessageCard teamsMessageCard = new TeamsMessageCard();
    teamsMessageCard.setPotentialAction(new ArrayList<>());
    teamsMessageCard.setSections(new ArrayList<>());
    teamsMessageCard.setSummary("Summary");
    teamsMessageCard.setText("Text");
    teamsMessageCard.setThemeColor("Theme Color");

    // Act and Assert
    assertEquals(teamsMessageCard, teamsMessageCard);
    int expectedHashCodeResult = teamsMessageCard.hashCode();
    assertEquals(expectedHashCodeResult, teamsMessageCard.hashCode());
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsMessageCard.equals(Object)", "int TeamsMessageCard.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ActionCard actionCard = new ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("MessageCard");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("MessageCard");

    ArrayList<ActionCard> potentialAction = new ArrayList<>();
    potentialAction.add(actionCard);

    TeamsMessageCard teamsMessageCard = new TeamsMessageCard();
    teamsMessageCard.setPotentialAction(potentialAction);
    teamsMessageCard.setSections(new ArrayList<>());
    teamsMessageCard.setSummary("Summary");
    teamsMessageCard.setText("Text");
    teamsMessageCard.setThemeColor("Theme Color");

    TeamsMessageCard teamsMessageCard2 = new TeamsMessageCard();
    teamsMessageCard2.setPotentialAction(new ArrayList<>());
    teamsMessageCard2.setSections(new ArrayList<>());
    teamsMessageCard2.setSummary("Summary");
    teamsMessageCard2.setText("Text");
    teamsMessageCard2.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(teamsMessageCard, teamsMessageCard2);
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsMessageCard.equals(Object)", "int TeamsMessageCard.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("MessageCard");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    ArrayList<Section> sections = new ArrayList<>();
    sections.add(section);

    TeamsMessageCard teamsMessageCard = new TeamsMessageCard();
    teamsMessageCard.setPotentialAction(new ArrayList<>());
    teamsMessageCard.setSections(sections);
    teamsMessageCard.setSummary("Summary");
    teamsMessageCard.setText("Text");
    teamsMessageCard.setThemeColor("Theme Color");

    TeamsMessageCard teamsMessageCard2 = new TeamsMessageCard();
    teamsMessageCard2.setPotentialAction(new ArrayList<>());
    teamsMessageCard2.setSections(new ArrayList<>());
    teamsMessageCard2.setSummary("Summary");
    teamsMessageCard2.setText("Text");
    teamsMessageCard2.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(teamsMessageCard, teamsMessageCard2);
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsMessageCard.equals(Object)", "int TeamsMessageCard.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsMessageCard teamsMessageCard = new TeamsMessageCard();
    teamsMessageCard.setPotentialAction(new ArrayList<>());
    teamsMessageCard.setSections(new ArrayList<>());
    teamsMessageCard.setSummary("MessageCard");
    teamsMessageCard.setText("Text");
    teamsMessageCard.setThemeColor("Theme Color");

    TeamsMessageCard teamsMessageCard2 = new TeamsMessageCard();
    teamsMessageCard2.setPotentialAction(new ArrayList<>());
    teamsMessageCard2.setSections(new ArrayList<>());
    teamsMessageCard2.setSummary("Summary");
    teamsMessageCard2.setText("Text");
    teamsMessageCard2.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(teamsMessageCard, teamsMessageCard2);
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsMessageCard.equals(Object)", "int TeamsMessageCard.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsMessageCard teamsMessageCard = new TeamsMessageCard();
    teamsMessageCard.setPotentialAction(new ArrayList<>());
    teamsMessageCard.setSections(new ArrayList<>());
    teamsMessageCard.setSummary(null);
    teamsMessageCard.setText("Text");
    teamsMessageCard.setThemeColor("Theme Color");

    TeamsMessageCard teamsMessageCard2 = new TeamsMessageCard();
    teamsMessageCard2.setPotentialAction(new ArrayList<>());
    teamsMessageCard2.setSections(new ArrayList<>());
    teamsMessageCard2.setSummary("Summary");
    teamsMessageCard2.setText("Text");
    teamsMessageCard2.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(teamsMessageCard, teamsMessageCard2);
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsMessageCard.equals(Object)", "int TeamsMessageCard.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TeamsMessageCard teamsMessageCard = new TeamsMessageCard();
    teamsMessageCard.setPotentialAction(new ArrayList<>());
    teamsMessageCard.setSections(new ArrayList<>());
    teamsMessageCard.setSummary("Summary");
    teamsMessageCard.setText("MessageCard");
    teamsMessageCard.setThemeColor("Theme Color");

    TeamsMessageCard teamsMessageCard2 = new TeamsMessageCard();
    teamsMessageCard2.setPotentialAction(new ArrayList<>());
    teamsMessageCard2.setSections(new ArrayList<>());
    teamsMessageCard2.setSummary("Summary");
    teamsMessageCard2.setText("Text");
    teamsMessageCard2.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(teamsMessageCard, teamsMessageCard2);
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsMessageCard.equals(Object)", "int TeamsMessageCard.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TeamsMessageCard teamsMessageCard = new TeamsMessageCard();
    teamsMessageCard.setPotentialAction(new ArrayList<>());
    teamsMessageCard.setSections(new ArrayList<>());
    teamsMessageCard.setSummary("Summary");
    teamsMessageCard.setText(null);
    teamsMessageCard.setThemeColor("Theme Color");

    TeamsMessageCard teamsMessageCard2 = new TeamsMessageCard();
    teamsMessageCard2.setPotentialAction(new ArrayList<>());
    teamsMessageCard2.setSections(new ArrayList<>());
    teamsMessageCard2.setSummary("Summary");
    teamsMessageCard2.setText("Text");
    teamsMessageCard2.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(teamsMessageCard, teamsMessageCard2);
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsMessageCard.equals(Object)", "int TeamsMessageCard.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TeamsMessageCard teamsMessageCard = new TeamsMessageCard();
    teamsMessageCard.setPotentialAction(new ArrayList<>());
    teamsMessageCard.setSections(new ArrayList<>());
    teamsMessageCard.setSummary("Summary");
    teamsMessageCard.setText("Text");
    teamsMessageCard.setThemeColor("MessageCard");

    TeamsMessageCard teamsMessageCard2 = new TeamsMessageCard();
    teamsMessageCard2.setPotentialAction(new ArrayList<>());
    teamsMessageCard2.setSections(new ArrayList<>());
    teamsMessageCard2.setSummary("Summary");
    teamsMessageCard2.setText("Text");
    teamsMessageCard2.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(teamsMessageCard, teamsMessageCard2);
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsMessageCard.equals(Object)", "int TeamsMessageCard.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TeamsMessageCard teamsMessageCard = new TeamsMessageCard();
    teamsMessageCard.setPotentialAction(new ArrayList<>());
    teamsMessageCard.setSections(new ArrayList<>());
    teamsMessageCard.setSummary("Summary");
    teamsMessageCard.setText("Text");
    teamsMessageCard.setThemeColor(null);

    TeamsMessageCard teamsMessageCard2 = new TeamsMessageCard();
    teamsMessageCard2.setPotentialAction(new ArrayList<>());
    teamsMessageCard2.setSections(new ArrayList<>());
    teamsMessageCard2.setSummary("Summary");
    teamsMessageCard2.setText("Text");
    teamsMessageCard2.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(teamsMessageCard, teamsMessageCard2);
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsMessageCard.equals(Object)", "int TeamsMessageCard.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard teamsMessageCard = new TeamsMessageCard();
    teamsMessageCard.setPotentialAction(new ArrayList<>());
    teamsMessageCard.setSections(new ArrayList<>());
    teamsMessageCard.setSummary("Summary");
    teamsMessageCard.setText("Text");
    teamsMessageCard.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(teamsMessageCard, null);
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsMessageCard.equals(Object)", "int TeamsMessageCard.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard teamsMessageCard = new TeamsMessageCard();
    teamsMessageCard.setPotentialAction(new ArrayList<>());
    teamsMessageCard.setSections(new ArrayList<>());
    teamsMessageCard.setSummary("Summary");
    teamsMessageCard.setText("Text");
    teamsMessageCard.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(teamsMessageCard, "Different type to TeamsMessageCard");
  }

  /**
   * Test {@link TeamsMessageCard#getContext()}.
   *
   * <p>Method under test: {@link TeamsMessageCard#getContext()}
   */
  @Test
  @DisplayName("Test getContext()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TeamsMessageCard.getContext()"})
  void testGetContext() {
    // Arrange, Act and Assert
    assertEquals("http://schema.org/extensions", teamsMessageCard.getContext());
  }

  /**
   * Test {@link TeamsMessageCard#getType()}.
   *
   * <p>Method under test: {@link TeamsMessageCard#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TeamsMessageCard.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("MessageCard", teamsMessageCard.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TeamsMessageCard}
   *   <li>{@link TeamsMessageCard#setPotentialAction(List)}
   *   <li>{@link TeamsMessageCard#setSections(List)}
   *   <li>{@link TeamsMessageCard#setSummary(String)}
   *   <li>{@link TeamsMessageCard#setText(String)}
   *   <li>{@link TeamsMessageCard#setThemeColor(String)}
   *   <li>{@link TeamsMessageCard#toString()}
   *   <li>{@link TeamsMessageCard#getPotentialAction()}
   *   <li>{@link TeamsMessageCard#getSections()}
   *   <li>{@link TeamsMessageCard#getSummary()}
   *   <li>{@link TeamsMessageCard#getText()}
   *   <li>{@link TeamsMessageCard#getThemeColor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TeamsMessageCard.<init>()",
    "List TeamsMessageCard.getPotentialAction()",
    "List TeamsMessageCard.getSections()",
    "String TeamsMessageCard.getSummary()",
    "String TeamsMessageCard.getText()",
    "String TeamsMessageCard.getThemeColor()",
    "void TeamsMessageCard.setPotentialAction(List)",
    "void TeamsMessageCard.setSections(List)",
    "void TeamsMessageCard.setSummary(String)",
    "void TeamsMessageCard.setText(String)",
    "void TeamsMessageCard.setThemeColor(String)",
    "String TeamsMessageCard.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TeamsMessageCard actualTeamsMessageCard = new TeamsMessageCard();
    ArrayList<ActionCard> potentialAction = new ArrayList<>();
    actualTeamsMessageCard.setPotentialAction(potentialAction);
    ArrayList<Section> sections = new ArrayList<>();
    actualTeamsMessageCard.setSections(sections);
    actualTeamsMessageCard.setSummary("Summary");
    actualTeamsMessageCard.setText("Text");
    actualTeamsMessageCard.setThemeColor("Theme Color");
    String actualToStringResult = actualTeamsMessageCard.toString();
    List<ActionCard> actualPotentialAction = actualTeamsMessageCard.getPotentialAction();
    List<Section> actualSections = actualTeamsMessageCard.getSections();
    String actualSummary = actualTeamsMessageCard.getSummary();
    String actualText = actualTeamsMessageCard.getText();

    // Assert
    assertEquals("Summary", actualSummary);
    assertEquals(
        "TeamsMessageCard(type=MessageCard, context=http://schema.org/extensions, themeColor=Theme Color,"
            + " summary=Summary, text=Text, sections=[], potentialAction=[])",
        actualToStringResult);
    assertEquals("Text", actualText);
    assertEquals("Theme Color", actualTeamsMessageCard.getThemeColor());
    assertTrue(actualPotentialAction.isEmpty());
    assertTrue(actualSections.isEmpty());
    assertSame(potentialAction, actualPotentialAction);
    assertSame(sections, actualSections);
  }

  /**
   * Test Section {@link Section#equals(Object)}, and {@link Section#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Section#equals(Object)}
   *   <li>{@link Section#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Section equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    Section section2 = new Section();
    section2.setActivityImage("Activity Image");
    section2.setActivitySubtitle("Dr");
    section2.setActivityTitle("Dr");
    section2.setFacts(new ArrayList<>());
    section2.setMarkdown(true);

    // Act and Assert
    assertEquals(section, section2);
    int expectedHashCodeResult = section.hashCode();
    assertEquals(expectedHashCodeResult, section2.hashCode());
  }

  /**
   * Test Section {@link Section#equals(Object)}, and {@link Section#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Section#equals(Object)}
   *   <li>{@link Section#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Section equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Section section = new Section();
    section.setActivityImage(null);
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    Section section2 = new Section();
    section2.setActivityImage(null);
    section2.setActivitySubtitle("Dr");
    section2.setActivityTitle("Dr");
    section2.setFacts(new ArrayList<>());
    section2.setMarkdown(true);

    // Act and Assert
    assertEquals(section, section2);
    int expectedHashCodeResult = section.hashCode();
    assertEquals(expectedHashCodeResult, section2.hashCode());
  }

  /**
   * Test Section {@link Section#equals(Object)}, and {@link Section#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Section#equals(Object)}
   *   <li>{@link Section#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Section equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle(null);
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    Section section2 = new Section();
    section2.setActivityImage("Activity Image");
    section2.setActivitySubtitle(null);
    section2.setActivityTitle("Dr");
    section2.setFacts(new ArrayList<>());
    section2.setMarkdown(true);

    // Act and Assert
    assertEquals(section, section2);
    int expectedHashCodeResult = section.hashCode();
    assertEquals(expectedHashCodeResult, section2.hashCode());
  }

  /**
   * Test Section {@link Section#equals(Object)}, and {@link Section#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Section#equals(Object)}
   *   <li>{@link Section#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Section equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle(null);
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    Section section2 = new Section();
    section2.setActivityImage("Activity Image");
    section2.setActivitySubtitle("Dr");
    section2.setActivityTitle(null);
    section2.setFacts(new ArrayList<>());
    section2.setMarkdown(true);

    // Act and Assert
    assertEquals(section, section2);
    int expectedHashCodeResult = section.hashCode();
    assertEquals(expectedHashCodeResult, section2.hashCode());
  }

  /**
   * Test Section {@link Section#equals(Object)}, and {@link Section#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Section#equals(Object)}
   *   <li>{@link Section#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    // Act and Assert
    assertEquals(section, section);
    int expectedHashCodeResult = section.hashCode();
    assertEquals(expectedHashCodeResult, section.hashCode());
  }

  /**
   * Test Section {@link Section#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("Dr");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    Section section2 = new Section();
    section2.setActivityImage("Activity Image");
    section2.setActivitySubtitle("Dr");
    section2.setActivityTitle("Dr");
    section2.setFacts(new ArrayList<>());
    section2.setMarkdown(true);

    // Act and Assert
    assertNotEquals(section, section2);
  }

  /**
   * Test Section {@link Section#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Section section = new Section();
    section.setActivityImage(null);
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    Section section2 = new Section();
    section2.setActivityImage("Activity Image");
    section2.setActivitySubtitle("Dr");
    section2.setActivityTitle("Dr");
    section2.setFacts(new ArrayList<>());
    section2.setMarkdown(true);

    // Act and Assert
    assertNotEquals(section, section2);
  }

  /**
   * Test Section {@link Section#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Mr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    Section section2 = new Section();
    section2.setActivityImage("Activity Image");
    section2.setActivitySubtitle("Dr");
    section2.setActivityTitle("Dr");
    section2.setFacts(new ArrayList<>());
    section2.setMarkdown(true);

    // Act and Assert
    assertNotEquals(section, section2);
  }

  /**
   * Test Section {@link Section#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle(null);
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    Section section2 = new Section();
    section2.setActivityImage("Activity Image");
    section2.setActivitySubtitle("Dr");
    section2.setActivityTitle("Dr");
    section2.setFacts(new ArrayList<>());
    section2.setMarkdown(true);

    // Act and Assert
    assertNotEquals(section, section2);
  }

  /**
   * Test Section {@link Section#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Mr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    Section section2 = new Section();
    section2.setActivityImage("Activity Image");
    section2.setActivitySubtitle("Dr");
    section2.setActivityTitle("Dr");
    section2.setFacts(new ArrayList<>());
    section2.setMarkdown(true);

    // Act and Assert
    assertNotEquals(section, section2);
  }

  /**
   * Test Section {@link Section#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle(null);
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    Section section2 = new Section();
    section2.setActivityImage("Activity Image");
    section2.setActivitySubtitle("Dr");
    section2.setActivityTitle("Dr");
    section2.setFacts(new ArrayList<>());
    section2.setMarkdown(true);

    // Act and Assert
    assertNotEquals(section, section2);
  }

  /**
   * Test Section {@link Section#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ArrayList<Fact> facts = new ArrayList<>();
    facts.add(new Fact("Dr", "42"));

    Section section = new Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(facts);
    section.setMarkdown(true);

    Section section2 = new Section();
    section2.setActivityImage("Activity Image");
    section2.setActivitySubtitle("Dr");
    section2.setActivityTitle("Dr");
    section2.setFacts(new ArrayList<>());
    section2.setMarkdown(true);

    // Act and Assert
    assertNotEquals(section, section2);
  }

  /**
   * Test Section {@link Section#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(false);

    Section section2 = new Section();
    section2.setActivityImage("Activity Image");
    section2.setActivitySubtitle("Dr");
    section2.setActivityTitle("Dr");
    section2.setFacts(new ArrayList<>());
    section2.setMarkdown(true);

    // Act and Assert
    assertNotEquals(section, section2);
  }

  /**
   * Test Section {@link Section#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    // Act and Assert
    assertNotEquals(section, null);
  }

  /**
   * Test Section {@link Section#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Section.equals(Object)", "int Section.hashCode()"})
  void testSectionEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Section section = new Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    // Act and Assert
    assertNotEquals(section, "Different type to Section");
  }

  /**
   * Test Section getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Section}
   *   <li>{@link Section#setActivityImage(String)}
   *   <li>{@link Section#setActivitySubtitle(String)}
   *   <li>{@link Section#setActivityTitle(String)}
   *   <li>{@link Section#setFacts(List)}
   *   <li>{@link Section#setMarkdown(boolean)}
   *   <li>{@link Section#toString()}
   *   <li>{@link Section#getActivityImage()}
   *   <li>{@link Section#getActivitySubtitle()}
   *   <li>{@link Section#getActivityTitle()}
   *   <li>{@link Section#getFacts()}
   *   <li>{@link Section#isMarkdown()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void Section.<init>()",
    "String Section.getActivityImage()",
    "String Section.getActivitySubtitle()",
    "String Section.getActivityTitle()",
    "List Section.getFacts()",
    "boolean Section.isMarkdown()",
    "void Section.setActivityImage(String)",
    "void Section.setActivitySubtitle(String)",
    "void Section.setActivityTitle(String)",
    "void Section.setFacts(List)",
    "void Section.setMarkdown(boolean)",
    "String Section.toString()"
  })
  void testSectionGettersAndSetters() {
    // Arrange and Act
    Section actualSection = new Section();
    actualSection.setActivityImage("Activity Image");
    actualSection.setActivitySubtitle("Dr");
    actualSection.setActivityTitle("Dr");
    ArrayList<Fact> facts = new ArrayList<>();
    actualSection.setFacts(facts);
    actualSection.setMarkdown(true);
    String actualToStringResult = actualSection.toString();
    String actualActivityImage = actualSection.getActivityImage();
    String actualActivitySubtitle = actualSection.getActivitySubtitle();
    String actualActivityTitle = actualSection.getActivityTitle();
    List<Fact> actualFacts = actualSection.getFacts();
    boolean actualIsMarkdownResult = actualSection.isMarkdown();

    // Assert
    assertEquals("Activity Image", actualActivityImage);
    assertEquals("Dr", actualActivitySubtitle);
    assertEquals("Dr", actualActivityTitle);
    assertEquals(
        "TeamsMessageCard.Section(activityTitle=Dr, activitySubtitle=Dr, activityImage=Activity Image, facts=[],"
            + " markdown=true)",
        actualToStringResult);
    assertTrue(actualFacts.isEmpty());
    assertTrue(actualIsMarkdownResult);
    assertSame(facts, actualFacts);
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}, and {@link Fact#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fact#equals(Object)}
   *   <li>{@link Fact#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Section_Fact equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Fact.equals(Object)", "int Fact.hashCode()"})
  void testSection_FactEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Fact fact = new Fact("Name", "42");
    Fact fact2 = new Fact("Name", "42");

    // Act and Assert
    assertEquals(fact, fact2);
    int expectedHashCodeResult = fact.hashCode();
    assertEquals(expectedHashCodeResult, fact2.hashCode());
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}, and {@link Fact#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fact#equals(Object)}
   *   <li>{@link Fact#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Section_Fact equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Fact.equals(Object)", "int Fact.hashCode()"})
  void testSection_FactEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Fact fact = new Fact(null, "42");
    Fact fact2 = new Fact(null, "42");

    // Act and Assert
    assertEquals(fact, fact2);
    int expectedHashCodeResult = fact.hashCode();
    assertEquals(expectedHashCodeResult, fact2.hashCode());
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}, and {@link Fact#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fact#equals(Object)}
   *   <li>{@link Fact#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Section_Fact equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Fact.equals(Object)", "int Fact.hashCode()"})
  void testSection_FactEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Fact fact = new Fact("Name", null);
    Fact fact2 = new Fact("Name", null);

    // Act and Assert
    assertEquals(fact, fact2);
    int expectedHashCodeResult = fact.hashCode();
    assertEquals(expectedHashCodeResult, fact2.hashCode());
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}, and {@link Fact#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fact#equals(Object)}
   *   <li>{@link Fact#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Section_Fact equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Fact.equals(Object)", "int Fact.hashCode()"})
  void testSection_FactEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Fact fact = new Fact("Name", "42");

    // Act and Assert
    assertEquals(fact, fact);
    int expectedHashCodeResult = fact.hashCode();
    assertEquals(expectedHashCodeResult, fact.hashCode());
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fact#equals(Object)}
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Fact.equals(Object)", "int Fact.hashCode()"})
  void testSection_FactEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Fact fact = new Fact("42", "42");

    // Act and Assert
    assertNotEquals(fact, new Fact("Name", "42"));
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fact#equals(Object)}
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Fact.equals(Object)", "int Fact.hashCode()"})
  void testSection_FactEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Fact fact = new Fact(null, "42");

    // Act and Assert
    assertNotEquals(fact, new Fact("Name", "42"));
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fact#equals(Object)}
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Fact.equals(Object)", "int Fact.hashCode()"})
  void testSection_FactEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Fact fact = new Fact("Name", "Name");

    // Act and Assert
    assertNotEquals(fact, new Fact("Name", "42"));
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fact#equals(Object)}
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Fact.equals(Object)", "int Fact.hashCode()"})
  void testSection_FactEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Fact fact = new Fact("Name", null);

    // Act and Assert
    assertNotEquals(fact, new Fact("Name", "42"));
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fact#equals(Object)}
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Fact.equals(Object)", "int Fact.hashCode()"})
  void testSection_FactEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Fact("Name", "42"), null);
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Fact#equals(Object)}
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Fact.equals(Object)", "int Fact.hashCode()"})
  void testSection_FactEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Fact("Name", "42"), "Different type to Fact");
  }

  /**
   * Test Section_Fact getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Fact#Fact(String, String)}
   *   <li>{@link Fact#toString()}
   *   <li>{@link Fact#getName()}
   *   <li>{@link Fact#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section_Fact getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void Fact.<init>(String, String)",
    "String Fact.getName()",
    "String Fact.getValue()",
    "String Fact.toString()"
  })
  void testSection_FactGettersAndSetters() {
    // Arrange and Act
    Fact actualFact = new Fact("Name", "42");
    String actualToStringResult = actualFact.toString();
    String actualName = actualFact.getName();

    // Assert
    assertEquals("42", actualFact.getValue());
    assertEquals("Name", actualName);
    assertEquals("TeamsMessageCard.Section.Fact(name=Name, value=42)", actualToStringResult);
  }
}
