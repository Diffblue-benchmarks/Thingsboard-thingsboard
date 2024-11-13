package org.thingsboard.server.service.notification.channels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
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
  @Autowired
  private TeamsMessageCard teamsMessageCard;

  /**
   * Test ActionCard {@link ActionCard#equals(Object)}, and
   * {@link ActionCard#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCardEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    TeamsMessageCard.ActionCard actionCard2 = new TeamsMessageCard.ActionCard();
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
   * Test ActionCard {@link ActionCard#equals(Object)}, and
   * {@link ActionCard#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard equals(Object), and hashCode(); when other is same; then return equal")
  void testActionCardEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<TeamsMessageCard.ActionCard.Action> actions = new ArrayList<>();
    actions.add(new TeamsMessageCard.ActionCard.Action("Type", "Type", "Type"));

    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
    actionCard.setActions(actions);
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    TeamsMessageCard.ActionCard actionCard2 = new TeamsMessageCard.ActionCard();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    ArrayList<TeamsMessageCard.ActionCard.Input> inputs = new ArrayList<>();
    inputs.add(input);

    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(inputs);
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    TeamsMessageCard.ActionCard actionCard2 = new TeamsMessageCard.ActionCard();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Type");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    TeamsMessageCard.ActionCard actionCard2 = new TeamsMessageCard.ActionCard();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName(null);
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    TeamsMessageCard.ActionCard actionCard2 = new TeamsMessageCard.ActionCard();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<TeamsMessageCard.ActionCard.Target> targets = new ArrayList<>();
    targets.add(new TeamsMessageCard.ActionCard.Target("Type", "Type"));

    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(targets);
    actionCard.setType("Type");

    TeamsMessageCard.ActionCard actionCard2 = new TeamsMessageCard.ActionCard();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Name");

    TeamsMessageCard.ActionCard actionCard2 = new TeamsMessageCard.ActionCard();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType(null);

    TeamsMessageCard.ActionCard actionCard2 = new TeamsMessageCard.ActionCard();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is different; then return not equal")
  void testActionCardEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ArrayList<TeamsMessageCard.ActionCard.Action> actions = new ArrayList<>();
    actions.add(mock(TeamsMessageCard.ActionCard.Action.class));

    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
    actionCard.setActions(actions);
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("Name");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("Type");

    TeamsMessageCard.ActionCard actionCard2 = new TeamsMessageCard.ActionCard();
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is 'null'; then return not equal")
  void testActionCardEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard equals(Object); when other is wrong type; then return not equal")
  void testActionCardEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TeamsMessageCard.ActionCard}
   *   <li>{@link TeamsMessageCard.ActionCard#setActions(List)}
   *   <li>{@link TeamsMessageCard.ActionCard#setInputs(List)}
   *   <li>{@link TeamsMessageCard.ActionCard#setName(String)}
   *   <li>{@link TeamsMessageCard.ActionCard#setTargets(List)}
   *   <li>{@link TeamsMessageCard.ActionCard#setType(String)}
   *   <li>{@link TeamsMessageCard.ActionCard#toString()}
   *   <li>{@link TeamsMessageCard.ActionCard#getActions()}
   *   <li>{@link TeamsMessageCard.ActionCard#getInputs()}
   *   <li>{@link TeamsMessageCard.ActionCard#getName()}
   *   <li>{@link TeamsMessageCard.ActionCard#getTargets()}
   *   <li>{@link TeamsMessageCard.ActionCard#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard getters and setters")
  void testActionCardGettersAndSetters() {
    // Arrange and Act
    TeamsMessageCard.ActionCard actualActionCard = new TeamsMessageCard.ActionCard();
    ArrayList<TeamsMessageCard.ActionCard.Action> actions = new ArrayList<>();
    actualActionCard.setActions(actions);
    ArrayList<TeamsMessageCard.ActionCard.Input> inputs = new ArrayList<>();
    actualActionCard.setInputs(inputs);
    actualActionCard.setName("Name");
    ArrayList<TeamsMessageCard.ActionCard.Target> targets = new ArrayList<>();
    actualActionCard.setTargets(targets);
    actualActionCard.setType("Type");
    String actualToStringResult = actualActionCard.toString();
    List<TeamsMessageCard.ActionCard.Action> actualActions = actualActionCard.getActions();
    List<TeamsMessageCard.ActionCard.Input> actualInputs = actualActionCard.getInputs();
    String actualName = actualActionCard.getName();
    List<TeamsMessageCard.ActionCard.Target> actualTargets = actualActionCard.getTargets();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("TeamsMessageCard.ActionCard(type=Type, name=Name, inputs=[], actions=[], targets=[])",
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
   * Test ActionCard_Action {@link Action#equals(Object)}, and
   * {@link Action#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Action#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_ActionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Action action = new TeamsMessageCard.ActionCard.Action("Type", "Name", "Target");
    TeamsMessageCard.ActionCard.Action action2 = new TeamsMessageCard.ActionCard.Action("Type", "Name", "Target");

    // Act and Assert
    assertEquals(action, action2);
    int expectedHashCodeResult = action.hashCode();
    assertEquals(expectedHashCodeResult, action2.hashCode());
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}, and
   * {@link Action#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Action#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_ActionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TeamsMessageCard.ActionCard.Action action = new TeamsMessageCard.ActionCard.Action(null, "Name", "Target");
    TeamsMessageCard.ActionCard.Action action2 = new TeamsMessageCard.ActionCard.Action(null, "Name", "Target");

    // Act and Assert
    assertEquals(action, action2);
    int expectedHashCodeResult = action.hashCode();
    assertEquals(expectedHashCodeResult, action2.hashCode());
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}, and
   * {@link Action#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Action#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_ActionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TeamsMessageCard.ActionCard.Action action = new TeamsMessageCard.ActionCard.Action("Type", null, "Target");
    TeamsMessageCard.ActionCard.Action action2 = new TeamsMessageCard.ActionCard.Action("Type", null, "Target");

    // Act and Assert
    assertEquals(action, action2);
    int expectedHashCodeResult = action.hashCode();
    assertEquals(expectedHashCodeResult, action2.hashCode());
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}, and
   * {@link Action#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Action#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_ActionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TeamsMessageCard.ActionCard.Action action = new TeamsMessageCard.ActionCard.Action("Type", "Name", null);
    TeamsMessageCard.ActionCard.Action action2 = new TeamsMessageCard.ActionCard.Action("Type", "Name", null);

    // Act and Assert
    assertEquals(action, action2);
    int expectedHashCodeResult = action.hashCode();
    assertEquals(expectedHashCodeResult, action2.hashCode());
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}, and
   * {@link Action#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Action#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object), and hashCode(); when other is same; then return equal")
  void testActionCard_ActionEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Action action = new TeamsMessageCard.ActionCard.Action("Type", "Name", "Target");

    // Act and Assert
    assertEquals(action, action);
    int expectedHashCodeResult = action.hashCode();
    assertEquals(expectedHashCodeResult, action.hashCode());
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object); when other is different; then return not equal")
  void testActionCard_ActionEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Action action = new TeamsMessageCard.ActionCard.Action("Name", "Name", "Target");

    // Act and Assert
    assertNotEquals(action, new TeamsMessageCard.ActionCard.Action("Type", "Name", "Target"));
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object); when other is different; then return not equal")
  void testActionCard_ActionEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsMessageCard.ActionCard.Action action = new TeamsMessageCard.ActionCard.Action(null, "Name", "Target");

    // Act and Assert
    assertNotEquals(action, new TeamsMessageCard.ActionCard.Action("Type", "Name", "Target"));
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object); when other is different; then return not equal")
  void testActionCard_ActionEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsMessageCard.ActionCard.Action action = new TeamsMessageCard.ActionCard.Action("Type", "Type", "Target");

    // Act and Assert
    assertNotEquals(action, new TeamsMessageCard.ActionCard.Action("Type", "Name", "Target"));
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object); when other is different; then return not equal")
  void testActionCard_ActionEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsMessageCard.ActionCard.Action action = new TeamsMessageCard.ActionCard.Action("Type", null, "Target");

    // Act and Assert
    assertNotEquals(action, new TeamsMessageCard.ActionCard.Action("Type", "Name", "Target"));
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object); when other is different; then return not equal")
  void testActionCard_ActionEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TeamsMessageCard.ActionCard.Action action = new TeamsMessageCard.ActionCard.Action("Type", "Name", "Type");

    // Act and Assert
    assertNotEquals(action, new TeamsMessageCard.ActionCard.Action("Type", "Name", "Target"));
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object); when other is different; then return not equal")
  void testActionCard_ActionEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TeamsMessageCard.ActionCard.Action action = new TeamsMessageCard.ActionCard.Action("Type", "Name", null);

    // Act and Assert
    assertNotEquals(action, new TeamsMessageCard.ActionCard.Action("Type", "Name", "Target"));
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object); when other is 'null'; then return not equal")
  void testActionCard_ActionEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMessageCard.ActionCard.Action("Type", "Name", "Target"), null);
  }

  /**
   * Test ActionCard_Action {@link Action#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Action#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Action equals(Object); when other is wrong type; then return not equal")
  void testActionCard_ActionEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMessageCard.ActionCard.Action("Type", "Name", "Target"), "Different type to Action");
  }

  /**
   * Test ActionCard_Action getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Action#Action(String, String, String)}
   *   <li>{@link TeamsMessageCard.ActionCard.Action#toString()}
   *   <li>{@link TeamsMessageCard.ActionCard.Action#getName()}
   *   <li>{@link TeamsMessageCard.ActionCard.Action#getTarget()}
   *   <li>{@link TeamsMessageCard.ActionCard.Action#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Action getters and setters")
  void testActionCard_ActionGettersAndSetters() {
    // Arrange and Act
    TeamsMessageCard.ActionCard.Action actualAction = new TeamsMessageCard.ActionCard.Action("Type", "Name", "Target");
    String actualToStringResult = actualAction.toString();
    String actualName = actualAction.getName();
    String actualTarget = actualAction.getTarget();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Target", actualTarget);
    assertEquals("TeamsMessageCard.ActionCard.Action(type=Type, name=Name, target=Target)", actualToStringResult);
    assertEquals("Type", actualAction.getType());
  }

  /**
   * Test ActionCard_Input {@link Input#equals(Object)}, and
   * {@link Input#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_InputEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    TeamsMessageCard.ActionCard.Input input2 = new TeamsMessageCard.ActionCard.Input();
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
   * Test ActionCard_Input {@link Input#equals(Object)}, and
   * {@link Input#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_InputEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId(null);
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    TeamsMessageCard.ActionCard.Input input2 = new TeamsMessageCard.ActionCard.Input();
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
   * Test ActionCard_Input {@link Input#equals(Object)}, and
   * {@link Input#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_InputEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle(null);
    input.setType("Type");

    TeamsMessageCard.ActionCard.Input input2 = new TeamsMessageCard.ActionCard.Input();
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
   * Test ActionCard_Input {@link Input#equals(Object)}, and
   * {@link Input#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_InputEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType(null);

    TeamsMessageCard.ActionCard.Input input2 = new TeamsMessageCard.ActionCard.Input();
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
   * Test ActionCard_Input {@link Input#equals(Object)}, and
   * {@link Input#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object), and hashCode(); when other is same; then return equal")
  void testActionCard_InputEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
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
   * Test ActionCard_Input {@link Input#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object); when other is different; then return not equal")
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId("Type");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    TeamsMessageCard.ActionCard.Input input2 = new TeamsMessageCard.ActionCard.Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link Input#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object); when other is different; then return not equal")
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId(null);
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    TeamsMessageCard.ActionCard.Input input2 = new TeamsMessageCard.ActionCard.Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link Input#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object); when other is different; then return not equal")
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId("42");
    input.setMultiSelect(false);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    TeamsMessageCard.ActionCard.Input input2 = new TeamsMessageCard.ActionCard.Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link Input#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object); when other is different; then return not equal")
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(false);
    input.setTitle("Dr");
    input.setType("Type");

    TeamsMessageCard.ActionCard.Input input2 = new TeamsMessageCard.ActionCard.Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link Input#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object); when other is different; then return not equal")
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Mr");
    input.setType("Type");

    TeamsMessageCard.ActionCard.Input input2 = new TeamsMessageCard.ActionCard.Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link Input#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object); when other is different; then return not equal")
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle(null);
    input.setType("Type");

    TeamsMessageCard.ActionCard.Input input2 = new TeamsMessageCard.ActionCard.Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link Input#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object); when other is different; then return not equal")
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("42");

    TeamsMessageCard.ActionCard.Input input2 = new TeamsMessageCard.ActionCard.Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link Input#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object); when other is different; then return not equal")
  void testActionCard_InputEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType(null);

    TeamsMessageCard.ActionCard.Input input2 = new TeamsMessageCard.ActionCard.Input();
    input2.setId("42");
    input2.setMultiSelect(true);
    input2.setMultiple(true);
    input2.setTitle("Dr");
    input2.setType("Type");

    // Act and Assert
    assertNotEquals(input, input2);
  }

  /**
   * Test ActionCard_Input {@link Input#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object); when other is 'null'; then return not equal")
  void testActionCard_InputEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
    input.setId("42");
    input.setMultiSelect(true);
    input.setMultiple(true);
    input.setTitle("Dr");
    input.setType("Type");

    // Act and Assert
    assertNotEquals(input, null);
  }

  /**
   * Test ActionCard_Input {@link Input#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Input#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input equals(Object); when other is wrong type; then return not equal")
  void testActionCard_InputEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Input input = new TeamsMessageCard.ActionCard.Input();
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TeamsMessageCard.ActionCard.Input}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#setId(String)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#setMultiSelect(boolean)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#setMultiple(boolean)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#setTitle(String)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#setType(String)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#toString()}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#getId()}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#getTitle()}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#getType()}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#isMultiSelect()}
   *   <li>{@link TeamsMessageCard.ActionCard.Input#isMultiple()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input getters and setters")
  void testActionCard_InputGettersAndSetters() {
    // Arrange and Act
    TeamsMessageCard.ActionCard.Input actualInput = new TeamsMessageCard.ActionCard.Input();
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

    // Assert that nothing has changed
    assertEquals("42", actualId);
    assertEquals("Dr", actualTitle);
    assertEquals("TeamsMessageCard.ActionCard.Input(type=Type, id=42, isMultiple=true, title=Dr, isMultiSelect=true)",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertTrue(actualIsMultiSelectResult);
    assertTrue(actualInput.isMultiple());
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}, and
   * {@link Choice#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Input.Choice#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input.Choice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input_Choice equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_Input_ChoiceEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Input.Choice choice = new TeamsMessageCard.ActionCard.Input.Choice("Display", "42");
    TeamsMessageCard.ActionCard.Input.Choice choice2 = new TeamsMessageCard.ActionCard.Input.Choice("Display", "42");

    // Act and Assert
    assertEquals(choice, choice2);
    int expectedHashCodeResult = choice.hashCode();
    assertEquals(expectedHashCodeResult, choice2.hashCode());
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}, and
   * {@link Choice#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Input.Choice#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input.Choice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input_Choice equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_Input_ChoiceEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TeamsMessageCard.ActionCard.Input.Choice choice = new TeamsMessageCard.ActionCard.Input.Choice(null, "42");
    TeamsMessageCard.ActionCard.Input.Choice choice2 = new TeamsMessageCard.ActionCard.Input.Choice(null, "42");

    // Act and Assert
    assertEquals(choice, choice2);
    int expectedHashCodeResult = choice.hashCode();
    assertEquals(expectedHashCodeResult, choice2.hashCode());
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}, and
   * {@link Choice#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Input.Choice#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input.Choice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input_Choice equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_Input_ChoiceEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TeamsMessageCard.ActionCard.Input.Choice choice = new TeamsMessageCard.ActionCard.Input.Choice("Display", null);
    TeamsMessageCard.ActionCard.Input.Choice choice2 = new TeamsMessageCard.ActionCard.Input.Choice("Display", null);

    // Act and Assert
    assertEquals(choice, choice2);
    int expectedHashCodeResult = choice.hashCode();
    assertEquals(expectedHashCodeResult, choice2.hashCode());
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}, and
   * {@link Choice#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Input.Choice#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input.Choice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input_Choice equals(Object), and hashCode(); when other is same; then return equal")
  void testActionCard_Input_ChoiceEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Input.Choice choice = new TeamsMessageCard.ActionCard.Input.Choice("Display", "42");

    // Act and Assert
    assertEquals(choice, choice);
    int expectedHashCodeResult = choice.hashCode();
    assertEquals(expectedHashCodeResult, choice.hashCode());
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsMessageCard.ActionCard.Input.Choice#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input_Choice equals(Object); when other is different; then return not equal")
  void testActionCard_Input_ChoiceEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Input.Choice choice = new TeamsMessageCard.ActionCard.Input.Choice("42", "42");

    // Act and Assert
    assertNotEquals(choice, new TeamsMessageCard.ActionCard.Input.Choice("Display", "42"));
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsMessageCard.ActionCard.Input.Choice#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input_Choice equals(Object); when other is different; then return not equal")
  void testActionCard_Input_ChoiceEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsMessageCard.ActionCard.Input.Choice choice = new TeamsMessageCard.ActionCard.Input.Choice(null, "42");

    // Act and Assert
    assertNotEquals(choice, new TeamsMessageCard.ActionCard.Input.Choice("Display", "42"));
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsMessageCard.ActionCard.Input.Choice#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input_Choice equals(Object); when other is different; then return not equal")
  void testActionCard_Input_ChoiceEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsMessageCard.ActionCard.Input.Choice choice = new TeamsMessageCard.ActionCard.Input.Choice("Display",
        "Display");

    // Act and Assert
    assertNotEquals(choice, new TeamsMessageCard.ActionCard.Input.Choice("Display", "42"));
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsMessageCard.ActionCard.Input.Choice#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input_Choice equals(Object); when other is different; then return not equal")
  void testActionCard_Input_ChoiceEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsMessageCard.ActionCard.Input.Choice choice = new TeamsMessageCard.ActionCard.Input.Choice("Display", null);

    // Act and Assert
    assertNotEquals(choice, new TeamsMessageCard.ActionCard.Input.Choice("Display", "42"));
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsMessageCard.ActionCard.Input.Choice#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input_Choice equals(Object); when other is 'null'; then return not equal")
  void testActionCard_Input_ChoiceEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMessageCard.ActionCard.Input.Choice("Display", "42"), null);
  }

  /**
   * Test ActionCard_Input_Choice {@link Choice#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsMessageCard.ActionCard.Input.Choice#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Input_Choice equals(Object); when other is wrong type; then return not equal")
  void testActionCard_Input_ChoiceEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMessageCard.ActionCard.Input.Choice("Display", "42"), "Different type to Choice");
  }

  /**
   * Test ActionCard_Input_Choice getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Input.Choice#Choice(String, String)}
   *   <li>{@link TeamsMessageCard.ActionCard.Input.Choice#toString()}
   *   <li>{@link TeamsMessageCard.ActionCard.Input.Choice#getDisplay()}
   *   <li>{@link TeamsMessageCard.ActionCard.Input.Choice#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Input_Choice getters and setters")
  void testActionCard_Input_ChoiceGettersAndSetters() {
    // Arrange and Act
    TeamsMessageCard.ActionCard.Input.Choice actualChoice = new TeamsMessageCard.ActionCard.Input.Choice("Display",
        "42");
    String actualToStringResult = actualChoice.toString();
    String actualDisplay = actualChoice.getDisplay();

    // Assert
    assertEquals("42", actualChoice.getValue());
    assertEquals("Display", actualDisplay);
    assertEquals("TeamsMessageCard.ActionCard.Input.Choice(display=Display, value=42)", actualToStringResult);
  }

  /**
   * Test ActionCard_Target {@link Target#equals(Object)}, and
   * {@link Target#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Target#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Target#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Target equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_TargetEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Target target = new TeamsMessageCard.ActionCard.Target("Os", "Uri");
    TeamsMessageCard.ActionCard.Target target2 = new TeamsMessageCard.ActionCard.Target("Os", "Uri");

    // Act and Assert
    assertEquals(target, target2);
    int expectedHashCodeResult = target.hashCode();
    assertEquals(expectedHashCodeResult, target2.hashCode());
  }

  /**
   * Test ActionCard_Target {@link Target#equals(Object)}, and
   * {@link Target#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Target#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Target#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Target equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_TargetEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TeamsMessageCard.ActionCard.Target target = new TeamsMessageCard.ActionCard.Target(null, "Uri");
    TeamsMessageCard.ActionCard.Target target2 = new TeamsMessageCard.ActionCard.Target(null, "Uri");

    // Act and Assert
    assertEquals(target, target2);
    int expectedHashCodeResult = target.hashCode();
    assertEquals(expectedHashCodeResult, target2.hashCode());
  }

  /**
   * Test ActionCard_Target {@link Target#equals(Object)}, and
   * {@link Target#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Target#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Target#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Target equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionCard_TargetEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TeamsMessageCard.ActionCard.Target target = new TeamsMessageCard.ActionCard.Target("Os", null);
    TeamsMessageCard.ActionCard.Target target2 = new TeamsMessageCard.ActionCard.Target("Os", null);

    // Act and Assert
    assertEquals(target, target2);
    int expectedHashCodeResult = target.hashCode();
    assertEquals(expectedHashCodeResult, target2.hashCode());
  }

  /**
   * Test ActionCard_Target {@link Target#equals(Object)}, and
   * {@link Target#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Target#equals(Object)}
   *   <li>{@link TeamsMessageCard.ActionCard.Target#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Target equals(Object), and hashCode(); when other is same; then return equal")
  void testActionCard_TargetEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Target target = new TeamsMessageCard.ActionCard.Target("Os", "Uri");

    // Act and Assert
    assertEquals(target, target);
    int expectedHashCodeResult = target.hashCode();
    assertEquals(expectedHashCodeResult, target.hashCode());
  }

  /**
   * Test ActionCard_Target {@link Target#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Target#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Target equals(Object); when other is different; then return not equal")
  void testActionCard_TargetEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.ActionCard.Target target = new TeamsMessageCard.ActionCard.Target("Uri", "Uri");

    // Act and Assert
    assertNotEquals(target, new TeamsMessageCard.ActionCard.Target("Os", "Uri"));
  }

  /**
   * Test ActionCard_Target {@link Target#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Target#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Target equals(Object); when other is different; then return not equal")
  void testActionCard_TargetEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsMessageCard.ActionCard.Target target = new TeamsMessageCard.ActionCard.Target(null, "Uri");

    // Act and Assert
    assertNotEquals(target, new TeamsMessageCard.ActionCard.Target("Os", "Uri"));
  }

  /**
   * Test ActionCard_Target {@link Target#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Target#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Target equals(Object); when other is different; then return not equal")
  void testActionCard_TargetEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsMessageCard.ActionCard.Target target = new TeamsMessageCard.ActionCard.Target("Os", "Os");

    // Act and Assert
    assertNotEquals(target, new TeamsMessageCard.ActionCard.Target("Os", "Uri"));
  }

  /**
   * Test ActionCard_Target {@link Target#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Target#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Target equals(Object); when other is different; then return not equal")
  void testActionCard_TargetEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsMessageCard.ActionCard.Target target = new TeamsMessageCard.ActionCard.Target("Os", null);

    // Act and Assert
    assertNotEquals(target, new TeamsMessageCard.ActionCard.Target("Os", "Uri"));
  }

  /**
   * Test ActionCard_Target {@link Target#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Target#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Target equals(Object); when other is 'null'; then return not equal")
  void testActionCard_TargetEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMessageCard.ActionCard.Target("Os", "Uri"), null);
  }

  /**
   * Test ActionCard_Target {@link Target#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.ActionCard.Target#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionCard_Target equals(Object); when other is wrong type; then return not equal")
  void testActionCard_TargetEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMessageCard.ActionCard.Target("Os", "Uri"), "Different type to Target");
  }

  /**
   * Test ActionCard_Target getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.ActionCard.Target#Target(String, String)}
   *   <li>{@link TeamsMessageCard.ActionCard.Target#toString()}
   *   <li>{@link TeamsMessageCard.ActionCard.Target#getOs()}
   *   <li>{@link TeamsMessageCard.ActionCard.Target#getUri()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionCard_Target getters and setters")
  void testActionCard_TargetGettersAndSetters() {
    // Arrange and Act
    TeamsMessageCard.ActionCard.Target actualTarget = new TeamsMessageCard.ActionCard.Target("Os", "Uri");
    String actualToStringResult = actualTarget.toString();
    String actualOs = actualTarget.getOs();

    // Assert
    assertEquals("Os", actualOs);
    assertEquals("TeamsMessageCard.ActionCard.Target(os=Os, uri=Uri)", actualToStringResult);
    assertEquals("Uri", actualTarget.getUri());
  }

  /**
   * Test {@link TeamsMessageCard#equals(Object)}, and
   * {@link TeamsMessageCard#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard#equals(Object)}
   *   <li>{@link TeamsMessageCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link TeamsMessageCard#equals(Object)}, and
   * {@link TeamsMessageCard#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard#equals(Object)}
   *   <li>{@link TeamsMessageCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.ActionCard actionCard = new TeamsMessageCard.ActionCard();
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("MessageCard");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("MessageCard");

    ArrayList<TeamsMessageCard.ActionCard> potentialAction = new ArrayList<>();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage("MessageCard");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    ArrayList<TeamsMessageCard.Section> sections = new ArrayList<>();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TeamsMessageCard.ActionCard actionCard = mock(TeamsMessageCard.ActionCard.class);
    doNothing().when(actionCard).setActions(Mockito.<List<TeamsMessageCard.ActionCard.Action>>any());
    doNothing().when(actionCard).setInputs(Mockito.<List<TeamsMessageCard.ActionCard.Input>>any());
    doNothing().when(actionCard).setName(Mockito.<String>any());
    doNothing().when(actionCard).setTargets(Mockito.<List<TeamsMessageCard.ActionCard.Target>>any());
    doNothing().when(actionCard).setType(Mockito.<String>any());
    actionCard.setActions(new ArrayList<>());
    actionCard.setInputs(new ArrayList<>());
    actionCard.setName("MessageCard");
    actionCard.setTargets(new ArrayList<>());
    actionCard.setType("MessageCard");

    ArrayList<TeamsMessageCard.ActionCard> potentialAction = new ArrayList<>();
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
   * <p>
   * Method under test: {@link TeamsMessageCard#getContext()}
   */
  @Test
  @DisplayName("Test getContext()")
  void testGetContext() {
    // Arrange, Act and Assert
    assertEquals("http://schema.org/extensions", (new TeamsMessageCard()).getContext());
  }

  /**
   * Test {@link TeamsMessageCard#getType()}.
   * <p>
   * Method under test: {@link TeamsMessageCard#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("MessageCard", (new TeamsMessageCard()).getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    TeamsMessageCard actualTeamsMessageCard = new TeamsMessageCard();
    ArrayList<TeamsMessageCard.ActionCard> potentialAction = new ArrayList<>();
    actualTeamsMessageCard.setPotentialAction(potentialAction);
    ArrayList<TeamsMessageCard.Section> sections = new ArrayList<>();
    actualTeamsMessageCard.setSections(sections);
    actualTeamsMessageCard.setSummary("Summary");
    actualTeamsMessageCard.setText("Text");
    actualTeamsMessageCard.setThemeColor("Theme Color");
    String actualToStringResult = actualTeamsMessageCard.toString();
    List<TeamsMessageCard.ActionCard> actualPotentialAction = actualTeamsMessageCard.getPotentialAction();
    List<TeamsMessageCard.Section> actualSections = actualTeamsMessageCard.getSections();
    String actualSummary = actualTeamsMessageCard.getSummary();
    String actualText = actualTeamsMessageCard.getText();

    // Assert that nothing has changed
    assertEquals("Summary", actualSummary);
    assertEquals("TeamsMessageCard(type=MessageCard, context=http://schema.org/extensions, themeColor=Theme Color,"
        + " summary=Summary, text=Text, sections=[], potentialAction=[])", actualToStringResult);
    assertEquals("Text", actualText);
    assertEquals("Theme Color", actualTeamsMessageCard.getThemeColor());
    assertTrue(actualPotentialAction.isEmpty());
    assertTrue(actualSections.isEmpty());
    assertSame(potentialAction, actualPotentialAction);
    assertSame(sections, actualSections);
  }

  /**
   * Test Section {@link Section#equals(Object)}, and {@link Section#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.Section#equals(Object)}
   *   <li>{@link TeamsMessageCard.Section#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section equals(Object), and hashCode(); when other is equal; then return equal")
  void testSectionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.Section#equals(Object)}
   *   <li>{@link TeamsMessageCard.Section#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section equals(Object), and hashCode(); when other is equal; then return equal")
  void testSectionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage(null);
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.Section#equals(Object)}
   *   <li>{@link TeamsMessageCard.Section#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section equals(Object), and hashCode(); when other is equal; then return equal")
  void testSectionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle(null);
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.Section#equals(Object)}
   *   <li>{@link TeamsMessageCard.Section#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section equals(Object), and hashCode(); when other is equal; then return equal")
  void testSectionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle(null);
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.Section#equals(Object)}
   *   <li>{@link TeamsMessageCard.Section#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section equals(Object), and hashCode(); when other is same; then return equal")
  void testSectionEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage("Dr");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage(null);
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Mr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle(null);
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Mr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle(null);
    section.setFacts(new ArrayList<>());
    section.setMarkdown(true);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ArrayList<TeamsMessageCard.Section.Fact> facts = new ArrayList<>();
    facts.add(new TeamsMessageCard.Section.Fact("Dr", "42"));

    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(facts);
    section.setMarkdown(true);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(new ArrayList<>());
    section.setMarkdown(false);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is different; then return not equal")
  void testSectionEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ArrayList<TeamsMessageCard.Section.Fact> facts = new ArrayList<>();
    facts.add(mock(TeamsMessageCard.Section.Fact.class));

    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
    section.setActivityImage("Activity Image");
    section.setActivitySubtitle("Dr");
    section.setActivityTitle("Dr");
    section.setFacts(facts);
    section.setMarkdown(true);

    TeamsMessageCard.Section section2 = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is 'null'; then return not equal")
  void testSectionEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section#equals(Object)}
   */
  @Test
  @DisplayName("Test Section equals(Object); when other is wrong type; then return not equal")
  void testSectionEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.Section section = new TeamsMessageCard.Section();
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TeamsMessageCard.Section}
   *   <li>{@link TeamsMessageCard.Section#setActivityImage(String)}
   *   <li>{@link TeamsMessageCard.Section#setActivitySubtitle(String)}
   *   <li>{@link TeamsMessageCard.Section#setActivityTitle(String)}
   *   <li>{@link TeamsMessageCard.Section#setFacts(List)}
   *   <li>{@link TeamsMessageCard.Section#setMarkdown(boolean)}
   *   <li>{@link TeamsMessageCard.Section#toString()}
   *   <li>{@link TeamsMessageCard.Section#getActivityImage()}
   *   <li>{@link TeamsMessageCard.Section#getActivitySubtitle()}
   *   <li>{@link TeamsMessageCard.Section#getActivityTitle()}
   *   <li>{@link TeamsMessageCard.Section#getFacts()}
   *   <li>{@link TeamsMessageCard.Section#isMarkdown()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section getters and setters")
  void testSectionGettersAndSetters() {
    // Arrange and Act
    TeamsMessageCard.Section actualSection = new TeamsMessageCard.Section();
    actualSection.setActivityImage("Activity Image");
    actualSection.setActivitySubtitle("Dr");
    actualSection.setActivityTitle("Dr");
    ArrayList<TeamsMessageCard.Section.Fact> facts = new ArrayList<>();
    actualSection.setFacts(facts);
    actualSection.setMarkdown(true);
    String actualToStringResult = actualSection.toString();
    String actualActivityImage = actualSection.getActivityImage();
    String actualActivitySubtitle = actualSection.getActivitySubtitle();
    String actualActivityTitle = actualSection.getActivityTitle();
    List<TeamsMessageCard.Section.Fact> actualFacts = actualSection.getFacts();
    boolean actualIsMarkdownResult = actualSection.isMarkdown();

    // Assert that nothing has changed
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.Section.Fact#equals(Object)}
   *   <li>{@link TeamsMessageCard.Section.Fact#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object), and hashCode(); when other is equal; then return equal")
  void testSection_FactEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.Section.Fact fact = new TeamsMessageCard.Section.Fact("Name", "42");
    TeamsMessageCard.Section.Fact fact2 = new TeamsMessageCard.Section.Fact("Name", "42");

    // Act and Assert
    assertEquals(fact, fact2);
    int expectedHashCodeResult = fact.hashCode();
    assertEquals(expectedHashCodeResult, fact2.hashCode());
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}, and {@link Fact#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.Section.Fact#equals(Object)}
   *   <li>{@link TeamsMessageCard.Section.Fact#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object), and hashCode(); when other is equal; then return equal")
  void testSection_FactEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TeamsMessageCard.Section.Fact fact = new TeamsMessageCard.Section.Fact(null, "42");
    TeamsMessageCard.Section.Fact fact2 = new TeamsMessageCard.Section.Fact(null, "42");

    // Act and Assert
    assertEquals(fact, fact2);
    int expectedHashCodeResult = fact.hashCode();
    assertEquals(expectedHashCodeResult, fact2.hashCode());
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}, and {@link Fact#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.Section.Fact#equals(Object)}
   *   <li>{@link TeamsMessageCard.Section.Fact#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object), and hashCode(); when other is equal; then return equal")
  void testSection_FactEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TeamsMessageCard.Section.Fact fact = new TeamsMessageCard.Section.Fact("Name", null);
    TeamsMessageCard.Section.Fact fact2 = new TeamsMessageCard.Section.Fact("Name", null);

    // Act and Assert
    assertEquals(fact, fact2);
    int expectedHashCodeResult = fact.hashCode();
    assertEquals(expectedHashCodeResult, fact2.hashCode());
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}, and {@link Fact#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.Section.Fact#equals(Object)}
   *   <li>{@link TeamsMessageCard.Section.Fact#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object), and hashCode(); when other is same; then return equal")
  void testSection_FactEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsMessageCard.Section.Fact fact = new TeamsMessageCard.Section.Fact("Name", "42");

    // Act and Assert
    assertEquals(fact, fact);
    int expectedHashCodeResult = fact.hashCode();
    assertEquals(expectedHashCodeResult, fact.hashCode());
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section.Fact#equals(Object)}
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object); when other is different; then return not equal")
  void testSection_FactEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsMessageCard.Section.Fact fact = new TeamsMessageCard.Section.Fact("42", "42");

    // Act and Assert
    assertNotEquals(fact, new TeamsMessageCard.Section.Fact("Name", "42"));
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section.Fact#equals(Object)}
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object); when other is different; then return not equal")
  void testSection_FactEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsMessageCard.Section.Fact fact = new TeamsMessageCard.Section.Fact(null, "42");

    // Act and Assert
    assertNotEquals(fact, new TeamsMessageCard.Section.Fact("Name", "42"));
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section.Fact#equals(Object)}
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object); when other is different; then return not equal")
  void testSection_FactEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsMessageCard.Section.Fact fact = new TeamsMessageCard.Section.Fact("Name", "Name");

    // Act and Assert
    assertNotEquals(fact, new TeamsMessageCard.Section.Fact("Name", "42"));
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section.Fact#equals(Object)}
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object); when other is different; then return not equal")
  void testSection_FactEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsMessageCard.Section.Fact fact = new TeamsMessageCard.Section.Fact("Name", null);

    // Act and Assert
    assertNotEquals(fact, new TeamsMessageCard.Section.Fact("Name", "42"));
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section.Fact#equals(Object)}
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object); when other is 'null'; then return not equal")
  void testSection_FactEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMessageCard.Section.Fact("Name", "42"), null);
  }

  /**
   * Test Section_Fact {@link Fact#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMessageCard.Section.Fact#equals(Object)}
   */
  @Test
  @DisplayName("Test Section_Fact equals(Object); when other is wrong type; then return not equal")
  void testSection_FactEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMessageCard.Section.Fact("Name", "42"), "Different type to Fact");
  }

  /**
   * Test Section_Fact getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMessageCard.Section.Fact#Fact(String, String)}
   *   <li>{@link TeamsMessageCard.Section.Fact#toString()}
   *   <li>{@link TeamsMessageCard.Section.Fact#getName()}
   *   <li>{@link TeamsMessageCard.Section.Fact#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test Section_Fact getters and setters")
  void testSection_FactGettersAndSetters() {
    // Arrange and Act
    TeamsMessageCard.Section.Fact actualFact = new TeamsMessageCard.Section.Fact("Name", "42");
    String actualToStringResult = actualFact.toString();
    String actualName = actualFact.getName();

    // Assert
    assertEquals("42", actualFact.getValue());
    assertEquals("Name", actualName);
    assertEquals("TeamsMessageCard.Section.Fact(name=Name, value=42)", actualToStringResult);
  }
}
