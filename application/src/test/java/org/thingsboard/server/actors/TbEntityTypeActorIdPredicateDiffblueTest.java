package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;

@ContextConfiguration(classes = {TbEntityTypeActorIdPredicate.class, EntityType.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class TbEntityTypeActorIdPredicateDiffblueTest {
  @MockBean private EntityType entityType;

  @Autowired private TbEntityTypeActorIdPredicate tbEntityTypeActorIdPredicate;

  /**
   * Test {@link TbEntityTypeActorIdPredicate#test(TbActorId)} with {@code TbActorId}.
   *
   * <p>Method under test: {@link TbEntityTypeActorIdPredicate#test(TbActorId)}
   */
  @Test
  @DisplayName("Test test(TbActorId) with 'TbActorId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityTypeActorIdPredicate.test(TbActorId)"})
  void testTestWithTbActorId() {
    // Arrange
    TbEntityActorId actorId = mock(TbEntityActorId.class);
    when(actorId.getEntityId())
        .thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    boolean actualTestResult = tbEntityTypeActorIdPredicate.test(actorId);

    // Assert
    verify(actorId).getEntityId();
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link TbEntityTypeActorIdPredicate#test(TbActorId)} with {@code TbActorId}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbEntityTypeActorIdPredicate#test(TbActorId)}
   */
  @Test
  @DisplayName("Test test(TbActorId) with 'TbActorId'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityTypeActorIdPredicate.test(TbActorId)"})
  void testTestWithTbActorId_thenReturnTrue() {
    // Arrange
    TbEntityTypeActorIdPredicate tbEntityTypeActorIdPredicate =
        new TbEntityTypeActorIdPredicate(EntityType.TENANT);

    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);

    TbEntityActorId actorId = mock(TbEntityActorId.class);
    when(actorId.getEntityId()).thenReturn(alarmId);

    // Act
    boolean actualTestResult = tbEntityTypeActorIdPredicate.test(actorId);

    // Assert
    verify(actorId).getEntityId();
    verify(alarmId).getEntityType();
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link TbEntityTypeActorIdPredicate#test(TbActorId)} with {@code TbActorId}.
   *
   * <ul>
   *   <li>When {@link TbActorId}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbEntityTypeActorIdPredicate#test(TbActorId)}
   */
  @Test
  @DisplayName("Test test(TbActorId) with 'TbActorId'; when TbActorId; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityTypeActorIdPredicate.test(TbActorId)"})
  void testTestWithTbActorId_whenTbActorId_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(tbEntityTypeActorIdPredicate.test(mock(TbActorId.class)));
  }

  /**
   * Test {@link TbEntityTypeActorIdPredicate#testEntityId(EntityId)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>When {@link AlarmId} {@link AlarmId#getEntityType()} return {@code TENANT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbEntityTypeActorIdPredicate#testEntityId(EntityId)}
   */
  @Test
  @DisplayName(
      "Test testEntityId(EntityId); given 'TENANT'; when AlarmId getEntityType() return 'TENANT'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityTypeActorIdPredicate.testEntityId(EntityId)"})
  void testTestEntityId_givenTenant_whenAlarmIdGetEntityTypeReturnTenant_thenReturnTrue() {
    // Arrange
    TbEntityTypeActorIdPredicate tbEntityTypeActorIdPredicate =
        new TbEntityTypeActorIdPredicate(EntityType.TENANT);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    boolean actualTestEntityIdResult = tbEntityTypeActorIdPredicate.testEntityId(entityId);

    // Assert
    verify(entityId).getEntityType();
    assertTrue(actualTestEntityIdResult);
  }

  /**
   * Test {@link TbEntityTypeActorIdPredicate#testEntityId(EntityId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbEntityTypeActorIdPredicate#testEntityId(EntityId)}
   */
  @Test
  @DisplayName("Test testEntityId(EntityId); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityTypeActorIdPredicate.testEntityId(EntityId)"})
  void testTestEntityId_thenReturnFalse() {
    // Arrange
    TbEntityTypeActorIdPredicate tbEntityTypeActorIdPredicate =
        new TbEntityTypeActorIdPredicate(EntityType.TENANT);

    // Act
    boolean actualTestEntityIdResult =
        tbEntityTypeActorIdPredicate.testEntityId(
            new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertFalse(actualTestEntityIdResult);
  }
}
