package org.thingsboard.server.dao.entity;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.dao.alarm.AlarmCommentDao;
import org.thingsboard.server.dao.alarm.BaseAlarmCommentService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseAlarmCommentService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class AbstractEntityServiceDiffblueTest {
  @Autowired private AbstractEntityService abstractEntityService;

  @MockBean private AlarmCommentDao alarmCommentDao;

  @MockBean private DataValidator<AlarmComment> dataValidator;

  @MockBean private EntityViewService entityViewService;

  @MockBean private RelationService relationService;

  /**
   * Test {@link AbstractEntityService#createRelation(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Then calls {@link RelationService#saveRelation(TenantId, EntityRelation)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityService#createRelation(TenantId, EntityRelation)}
   */
  @Test
  @DisplayName(
      "Test createRelation(TenantId, EntityRelation); then calls saveRelation(TenantId, EntityRelation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.createRelation(TenantId, EntityRelation)"})
  void testCreateRelation_thenCallsSaveRelation() {
    // Arrange
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());

    // Act
    abstractEntityService.createRelation(ModelConstants.SYSTEM_TENANT, new EntityRelation());

    // Assert
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link AbstractEntityService#deleteRelation(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Then calls {@link RelationService#deleteRelation(TenantId, EntityRelation)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @DisplayName(
      "Test deleteRelation(TenantId, EntityRelation); then calls deleteRelation(TenantId, EntityRelation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.deleteRelation(TenantId, EntityRelation)"})
  void testDeleteRelation_thenCallsDeleteRelation() {
    // Arrange
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(true);

    // Act
    abstractEntityService.deleteRelation(ModelConstants.SYSTEM_TENANT, new EntityRelation());

    // Assert
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link AbstractEntityService#extractConstraintViolationException(Exception)}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractEntityService#extractConstraintViolationException(Exception)}
   */
  @Test
  @DisplayName("Test extractConstraintViolationException(Exception); then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional AbstractEntityService.extractConstraintViolationException(Exception)"
  })
  void testExtractConstraintViolationException_thenReturnPresent() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    t.initCause(constraintViolationException);

    // Act
    Optional<ConstraintViolationException> actualExtractConstraintViolationExceptionResult =
        AbstractEntityService.extractConstraintViolationException(t);

    // Assert
    assertTrue(actualExtractConstraintViolationExceptionResult.isPresent());
    assertSame(constraintViolationException, actualExtractConstraintViolationExceptionResult.get());
  }

  /**
   * Test {@link AbstractEntityService#extractConstraintViolationException(Exception)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractEntityService#extractConstraintViolationException(Exception)}
   */
  @Test
  @DisplayName(
      "Test extractConstraintViolationException(Exception); when Exception(); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional AbstractEntityService.extractConstraintViolationException(Exception)"
  })
  void testExtractConstraintViolationException_whenException_thenReturnNotPresent() {
    // Arrange and Act
    Optional<ConstraintViolationException> actualExtractConstraintViolationExceptionResult =
        AbstractEntityService.extractConstraintViolationException(new Exception());

    // Assert
    assertFalse(actualExtractConstraintViolationExceptionResult.isPresent());
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, String, String, String,
   * String)} with {@code t}, {@code constraintName1}, {@code constraintMessage1}, {@code
   * constraintName2}, {@code constraintMessage2}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, String, String, String, String) with 't', 'constraintName1', 'constraintMessage1', 'constraintName2', 'constraintMessage2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String, String, String)"
  })
  void
      testCheckConstraintViolationWithTConstraintName1ConstraintMessage1ConstraintName2ConstraintMessage2() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            AbstractEntityService.checkConstraintViolation(
                new Exception(),
                "Constraint Name1",
                "Constraint Message1",
                "Constraint Name2",
                "Constraint Message2"));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, String, String, String,
   * String)} with {@code t}, {@code constraintName1}, {@code constraintMessage1}, {@code
   * constraintName2}, {@code constraintMessage2}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, String, String, String, String) with 't', 'constraintName1', 'constraintMessage1', 'constraintName2', 'constraintMessage2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String, String, String)"
  })
  void
      testCheckConstraintViolationWithTConstraintName1ConstraintMessage1ConstraintName2ConstraintMessage22() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    t.initCause(constraintViolationException);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            AbstractEntityService.checkConstraintViolation(
                t,
                "Constraint Name1",
                "Constraint Message1",
                "Constraint Name2",
                "Constraint Message2"));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, String, String, String,
   * String)} with {@code t}, {@code constraintName1}, {@code constraintMessage1}, {@code
   * constraintName2}, {@code constraintMessage2}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, String, String, String, String) with 't', 'constraintName1', 'constraintMessage1', 'constraintName2', 'constraintMessage2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String, String, String)"
  })
  void
      testCheckConstraintViolationWithTConstraintName1ConstraintMessage1ConstraintName2ConstraintMessage23() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name2");
    t.initCause(constraintViolationException);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            AbstractEntityService.checkConstraintViolation(
                t,
                "Constraint Name1",
                "Constraint Message1",
                "Constraint Name2",
                "Constraint Message2"));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, String, String, String,
   * String)} with {@code t}, {@code constraintName1}, {@code constraintMessage1}, {@code
   * constraintName2}, {@code constraintMessage2}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, String, String, String, String) with 't', 'constraintName1', 'constraintMessage1', 'constraintName2', 'constraintMessage2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String, String, String)"
  })
  void
      testCheckConstraintViolationWithTConstraintName1ConstraintMessage1ConstraintName2ConstraintMessage24() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), "");
    t.initCause(constraintViolationException);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            AbstractEntityService.checkConstraintViolation(
                t,
                "Constraint Name1",
                "Constraint Message1",
                "Constraint Name2",
                "Constraint Message2"));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, String, String)} with
   * {@code t}, {@code constraintName}, {@code constraintMessage}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, String, String) with 't', 'constraintName', 'constraintMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String)"
  })
  void testCheckConstraintViolationWithTConstraintNameConstraintMessage() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    t.initCause(constraintViolationException);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            AbstractEntityService.checkConstraintViolation(
                t, "Constraint Name", "Constraint Message"));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, String, String)} with
   * {@code t}, {@code constraintName}, {@code constraintMessage}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, String, String) with 't', 'constraintName', 'constraintMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String)"
  })
  void testCheckConstraintViolationWithTConstraintNameConstraintMessage2() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), "42");
    t.initCause(constraintViolationException);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            AbstractEntityService.checkConstraintViolation(
                t, "Constraint Name", "Constraint Message"));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, String, String)} with
   * {@code t}, {@code constraintName}, {@code constraintMessage}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, String, String) with 't', 'constraintName', 'constraintMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String)"
  })
  void testCheckConstraintViolationWithTConstraintNameConstraintMessage3() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), "");
    t.initCause(constraintViolationException);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            AbstractEntityService.checkConstraintViolation(
                t, "Constraint Name", "Constraint Message"));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, String, String)} with
   * {@code t}, {@code constraintName}, {@code constraintMessage}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, String, String) with 't', 'constraintName', 'constraintMessage'; when Exception()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String)"
  })
  void testCheckConstraintViolationWithTConstraintNameConstraintMessage_whenException() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            AbstractEntityService.checkConstraintViolation(
                new Exception(), "Constraint Name", "Constraint Message"));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, Map)} with {@code t},
   * {@code constraints}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, Map)}
   */
  @Test
  @DisplayName("Test checkConstraintViolation(Exception, Map) with 't', 'constraints'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.checkConstraintViolation(Exception, Map)"})
  void testCheckConstraintViolationWithTConstraints() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    t.initCause(constraintViolationException);

    // Act and Assert
    assertDoesNotThrow(() -> AbstractEntityService.checkConstraintViolation(t, new HashMap<>()));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, Map)} with {@code t},
   * {@code constraints}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, Map)}
   */
  @Test
  @DisplayName("Test checkConstraintViolation(Exception, Map) with 't', 'constraints'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.checkConstraintViolation(Exception, Map)"})
  void testCheckConstraintViolationWithTConstraints2() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), "");
    t.initCause(constraintViolationException);

    // Act and Assert
    assertDoesNotThrow(() -> AbstractEntityService.checkConstraintViolation(t, new HashMap<>()));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, Map)} with {@code t},
   * {@code constraints}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, Map)}
   */
  @Test
  @DisplayName("Test checkConstraintViolation(Exception, Map) with 't', 'constraints'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.checkConstraintViolation(Exception, Map)"})
  void testCheckConstraintViolationWithTConstraints3() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    t.initCause(constraintViolationException);

    HashMap<String, String> constraints = new HashMap<>();
    constraints.put("42", "Value");

    // Act and Assert
    assertDoesNotThrow(() -> AbstractEntityService.checkConstraintViolation(t, constraints));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, Map)} with {@code t},
   * {@code constraints}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, Map)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, Map) with 't', 'constraints'; then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.checkConstraintViolation(Exception, Map)"})
  void testCheckConstraintViolationWithTConstraints_thenThrowDataValidationException() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), "42");
    t.initCause(constraintViolationException);

    HashMap<String, String> constraints = new HashMap<>();
    constraints.put("42", "Value");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> AbstractEntityService.checkConstraintViolation(t, constraints));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, Map)} with {@code t},
   * {@code constraints}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, Map)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, Map) with 't', 'constraints'; when Exception(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.checkConstraintViolation(Exception, Map)"})
  void testCheckConstraintViolationWithTConstraints_whenException_thenDoesNotThrow() {
    // Arrange
    Exception t = new Exception();

    // Act and Assert
    assertDoesNotThrow(() -> AbstractEntityService.checkConstraintViolation(t, new HashMap<>()));
  }

  /**
   * Test {@link AbstractEntityService#checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link RelationService} {@link RelationService#checkRelation(TenantId, EntityId,
   *       EntityId, String, RelationTypeGroup)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityService#checkAssignedEntityViewsToEdge(TenantId,
   * EntityId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId); given RelationService checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)"
  })
  void testCheckAssignedEntityViewsToEdge_givenRelationServiceCheckRelationReturnFalse() {
    // Arrange
    ArrayList<EntityView> entityViewList = new ArrayList<>();
    entityViewList.add(new EntityView());
    when(entityViewService.findEntityViewsByTenantIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityViewList);
    when(relationService.checkRelation(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(false);

    // Act
    abstractEntityService.checkAssignedEntityViewsToEdge(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null);

    // Assert
    verify(entityViewService)
        .findEntityViewsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(relationService)
        .checkRelation(
            isA(TenantId.class), isNull(), isNull(), eq("Contains"), eq(RelationTypeGroup.EDGE));
  }

  /**
   * Test {@link AbstractEntityService#checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityViewService#findEntityViewsByTenantIdAndEntityId(TenantId,
   *       EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityService#checkAssignedEntityViewsToEdge(TenantId,
   * EntityId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId); then calls findEntityViewsByTenantIdAndEntityId(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)"
  })
  void testCheckAssignedEntityViewsToEdge_thenCallsFindEntityViewsByTenantIdAndEntityId() {
    // Arrange
    when(entityViewService.findEntityViewsByTenantIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    abstractEntityService.checkAssignedEntityViewsToEdge(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null);

    // Assert
    verify(entityViewService)
        .findEntityViewsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link AbstractEntityService#checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityService#checkAssignedEntityViewsToEdge(TenantId,
   * EntityId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)"
  })
  void testCheckAssignedEntityViewsToEdge_thenThrowDataValidationException() {
    // Arrange
    ArrayList<EntityView> entityViewList = new ArrayList<>();
    entityViewList.add(new EntityView());
    when(entityViewService.findEntityViewsByTenantIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityViewList);
    when(relationService.checkRelation(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            abstractEntityService.checkAssignedEntityViewsToEdge(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
    verify(entityViewService)
        .findEntityViewsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(relationService)
        .checkRelation(
            isA(TenantId.class), isNull(), isNull(), eq("Contains"), eq(RelationTypeGroup.EDGE));
  }
}
