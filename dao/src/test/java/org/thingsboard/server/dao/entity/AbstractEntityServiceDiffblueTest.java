/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractEntityServiceDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.createRelation(TenantId, EntityRelation)"})
  public void testCreateRelation_thenCallsSaveRelation() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelation_thenCallsDeleteRelation() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional AbstractEntityService.extractConstraintViolationException(Exception)"
  })
  public void testExtractConstraintViolationException_thenReturnPresent() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional AbstractEntityService.extractConstraintViolationException(Exception)"
  })
  public void testExtractConstraintViolationException_whenException_thenReturnNotPresent() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String, String, String)"
  })
  public void
      testCheckConstraintViolationWithTConstraintName1ConstraintMessage1ConstraintName2ConstraintMessage2() {
    // Arrange, Act and Assert
    AbstractEntityService.checkConstraintViolation(
        new Exception(),
        "Constraint Name1",
        "Constraint Message1",
        "Constraint Name2",
        "Constraint Message2");
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String, String, String)"
  })
  public void
      testCheckConstraintViolationWithTConstraintName1ConstraintMessage1ConstraintName2ConstraintMessage22() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    t.initCause(constraintViolationException);

    // Act and Assert
    AbstractEntityService.checkConstraintViolation(
        t, "Constraint Name1", "Constraint Message1", "Constraint Name2", "Constraint Message2");
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String, String, String)"
  })
  public void
      testCheckConstraintViolationWithTConstraintName1ConstraintMessage1ConstraintName2ConstraintMessage23() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name1");
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String, String, String)"
  })
  public void
      testCheckConstraintViolationWithTConstraintName1ConstraintMessage1ConstraintName2ConstraintMessage24() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), "");
    t.initCause(constraintViolationException);

    // Act and Assert
    AbstractEntityService.checkConstraintViolation(
        t, "Constraint Name1", "Constraint Message1", "Constraint Name2", "Constraint Message2");
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, String, String)} with
   * {@code t}, {@code constraintName}, {@code constraintMessage}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String)"
  })
  public void testCheckConstraintViolationWithTConstraintNameConstraintMessage() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String)"
  })
  public void testCheckConstraintViolationWithTConstraintNameConstraintMessage2() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), "42");
    t.initCause(constraintViolationException);

    // Act and Assert
    AbstractEntityService.checkConstraintViolation(t, "Constraint Name", "Constraint Message");
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, String, String)} with
   * {@code t}, {@code constraintName}, {@code constraintMessage}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String)"
  })
  public void testCheckConstraintViolationWithTConstraintNameConstraintMessage3() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), "");
    t.initCause(constraintViolationException);

    // Act and Assert
    AbstractEntityService.checkConstraintViolation(t, "Constraint Name", "Constraint Message");
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String)"
  })
  public void testCheckConstraintViolationWithTConstraintNameConstraintMessage_whenException() {
    // Arrange, Act and Assert
    AbstractEntityService.checkConstraintViolation(
        new Exception(), "Constraint Name", "Constraint Message");
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, Map)} with {@code t},
   * {@code constraints}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.checkConstraintViolation(Exception, Map)"})
  public void testCheckConstraintViolationWithTConstraints() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    t.initCause(constraintViolationException);

    // Act and Assert
    AbstractEntityService.checkConstraintViolation(t, new HashMap<>());
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, Map)} with {@code t},
   * {@code constraints}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.checkConstraintViolation(Exception, Map)"})
  public void testCheckConstraintViolationWithTConstraints2() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), "");
    t.initCause(constraintViolationException);

    // Act and Assert
    AbstractEntityService.checkConstraintViolation(t, new HashMap<>());
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, Map)} with {@code t},
   * {@code constraints}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.checkConstraintViolation(Exception, Map)"})
  public void testCheckConstraintViolationWithTConstraints3() {
    // Arrange
    Exception t = new Exception("An error occurred");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    t.initCause(constraintViolationException);

    HashMap<String, String> constraints = new HashMap<>();
    constraints.put("42", "Value");

    // Act and Assert
    AbstractEntityService.checkConstraintViolation(t, constraints);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.checkConstraintViolation(Exception, Map)"})
  public void testCheckConstraintViolationWithTConstraints_thenThrowDataValidationException() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityService.checkConstraintViolation(Exception, Map)"})
  public void testCheckConstraintViolationWithTConstraints_whenException_thenDoesNotThrow() {
    // Arrange
    Exception t = new Exception();

    // Act and Assert
    AbstractEntityService.checkConstraintViolation(t, new HashMap<>());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)"
  })
  public void testCheckAssignedEntityViewsToEdge_givenRelationServiceCheckRelationReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)"
  })
  public void testCheckAssignedEntityViewsToEdge_thenCallsFindEntityViewsByTenantIdAndEntityId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractEntityService.checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)"
  })
  public void testCheckAssignedEntityViewsToEdge_thenThrowDataValidationException() {
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
