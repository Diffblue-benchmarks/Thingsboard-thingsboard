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
package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.query.ComplexFilterPredicate;
import org.thingsboard.server.common.data.query.ComplexFilterPredicate.ComplexOperation;
import org.thingsboard.server.common.data.query.EntityCountQuery;
import org.thingsboard.server.common.data.query.EntityDataPageLink;
import org.thingsboard.server.common.data.query.EntityDataQuery;
import org.thingsboard.server.common.data.query.EntityDataSortOrder;
import org.thingsboard.server.common.data.query.EntityFilter;
import org.thingsboard.server.common.data.query.EntityFilterType;
import org.thingsboard.server.common.data.query.EntityKey;
import org.thingsboard.server.common.data.query.EntityKeyType;
import org.thingsboard.server.common.data.query.EntityKeyValueType;
import org.thingsboard.server.common.data.query.KeyFilter;
import org.thingsboard.server.common.data.query.KeyFilterPredicate;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityKeyMappingDiffblueTest {
  /**
   * Test {@link EntityKeyMapping#hasFilter()}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) KeyFilters is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#hasFilter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.hasFilter()"})
  public void testHasFilter_givenEntityKeyMappingKeyFiltersIsArrayList_thenReturnFalse() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setKeyFilters(new ArrayList<>());

    // Act and Assert
    assertFalse(entityKeyMapping.hasFilter());
  }

  /**
   * Test {@link EntityKeyMapping#hasFilter()}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#hasFilter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.hasFilter()"})
  public void testHasFilter_givenEntityKeyMapping_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EntityKeyMapping().hasFilter());
  }

  /**
   * Test {@link EntityKeyMapping#hasFilter()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#hasFilter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.hasFilter()"})
  public void testHasFilter_thenReturnTrue() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    keyFilters.add(keyFilter);

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setKeyFilters(keyFilters);

    // Act and Assert
    assertTrue(entityKeyMapping.hasFilter());
  }

  /**
   * Test {@link EntityKeyMapping#getValueAlias()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#getValueAlias()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.getValueAlias()"})
  public void testGetValueAlias_thenReturnNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "Key"));

    // Act and Assert
    assertNull(entityKeyMapping.getValueAlias());
  }

  /**
   * Test {@link EntityKeyMapping#getValueAlias()}.
   *
   * <ul>
   *   <li>Then return {@code null_value}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#getValueAlias()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.getValueAlias()"})
  public void testGetValueAlias_thenReturnNullValue() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertEquals("null_value", entityKeyMapping.getValueAlias());
  }

  /**
   * Test {@link EntityKeyMapping#getTsAlias()}.
   *
   * <p>Method under test: {@link EntityKeyMapping#getTsAlias()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.getTsAlias()"})
  public void testGetTsAlias() {
    // Arrange, Act and Assert
    assertEquals("null_ts", new EntityKeyMapping().getTsAlias());
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   *
   * <p>Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(
        new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ENTITY_TYPE));
    entityKeyMapping.setEntityKeyColumn("foo");
    entityKeyMapping.setSortOrder(false);

    // Act and Assert
    assertEquals(
        "(coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast(null.long_v"
            + " as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v as varchar),"
            + " '')) as null_value, null.last_update_ts as null_ts",
        entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   *
   * <p>Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection2() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(
        new EntityKey(EntityKeyType.TIME_SERIES, EntityKeyMapping.ENTITY_TYPE));
    entityKeyMapping.setEntityKeyColumn("foo");
    entityKeyMapping.setSortOrder(false);

    // Act and Assert
    assertEquals(
        "(coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast(null.long_v"
            + " as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v as varchar),"
            + " '')) as null_value, null.ts as null_ts",
        entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) Index is one.
   *   <li>When {@code RELATIONS_QUERY}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_givenEntityKeyMappingIndexIsOne_whenRelationsQuery() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setIndex(1);
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "'%s' as %s"));
    entityKeyMapping.setEntityKeyColumn(null);
    entityKeyMapping.setSortOrder(false);

    // Act and Assert
    assertEquals(
        "'' as null",
        entityKeyMapping.toSelection(EntityFilterType.RELATIONS_QUERY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) Index is one.
   *   <li>When {@code RELATIONS_QUERY}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_givenEntityKeyMappingIndexIsOne_whenRelationsQuery2() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setIndex(1);
    entityKeyMapping.setEntityKey(
        new EntityKey(EntityKeyType.ENTITY_FIELD, EntityKeyMapping.ENTITY_TYPE));
    entityKeyMapping.setEntityKeyColumn(null);
    entityKeyMapping.setSortOrder(false);

    // Act and Assert
    assertEquals(
        "'' as null",
        entityKeyMapping.toSelection(EntityFilterType.RELATIONS_QUERY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) SortOrder is {@code true}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_givenEntityKeyMappingSortOrderIsTrue_thenReturnAString() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(
        new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ENTITY_TYPE));
    entityKeyMapping.setEntityKeyColumn("foo");
    entityKeyMapping.setSortOrder(true);

    // Act and Assert
    assertEquals(
        "(coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast(null.long_v"
            + " as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v as varchar),"
            + " '')) as null_value, null.last_update_ts as null_ts, coalesce(null.dbl_v, cast(null.long_v as double"
            + " precision), (case when null.bool_v then 1 else 0 end)) null_value_so_num,coalesce(null.str_v,"
            + " cast(null.json_v as varchar), '') null_value_so_varchar",
        entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>Then return {@code '' as null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_thenReturnAsNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "'%s' as %s"));
    entityKeyMapping.setEntityKeyColumn(null);
    entityKeyMapping.setSortOrder(false);

    // Act and Assert
    assertEquals(
        "'' as null",
        entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>Then return {@code cast(e.foo as varchar) as null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_thenReturnCastEFooAsVarcharAsNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "'%s' as %s"));
    entityKeyMapping.setEntityKeyColumn("foo");
    entityKeyMapping.setSortOrder(false);

    // Act and Assert
    assertEquals(
        "cast(e.foo as varchar) as null",
        entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>Then return {@code 'TENANT' as null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_thenReturnTenantAsNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(
        new EntityKey(EntityKeyType.ENTITY_FIELD, EntityKeyMapping.ENTITY_TYPE));
    entityKeyMapping.setEntityKeyColumn("foo");
    entityKeyMapping.setSortOrder(false);

    // Act and Assert
    assertEquals(
        "'TENANT' as null",
        entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code '' as null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_whenNull_thenReturnAsNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "'%s' as %s"));
    entityKeyMapping.setEntityKeyColumn(null);
    entityKeyMapping.setSortOrder(false);

    // Act and Assert
    assertEquals("'' as null", entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, null));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>When {@code USER}.
   *   <li>Then return {@code '' as null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_whenUser_thenReturnAsNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "'%s' as %s"));
    entityKeyMapping.setEntityKeyColumn(null);
    entityKeyMapping.setSortOrder(false);

    // Act and Assert
    assertEquals(
        "'' as null",
        entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.USER));
  }

  /**
   * Test {@link EntityKeyMapping#toQueries(QueryContext, EntityFilterType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKey} {@link EntityKey#getType()} return {@code ATTRIBUTE}.
   *   <li>Then calls {@link EntityKey#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toQueries(QueryContext, EntityFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream EntityKeyMapping.toQueries(QueryContext, EntityFilterType)"})
  public void testToQueries_givenEntityKeyGetTypeReturnAttribute_thenCallsGetType() {
    // Arrange
    ComplexFilterPredicate predicate = new ComplexFilterPredicate();
    predicate.setOperation(ComplexOperation.AND);
    predicate.setPredicates(new ArrayList<>());

    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setValueType(EntityKeyValueType.STRING);
    keyFilter.setPredicate(predicate);
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ENTITY_TYPE));

    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    keyFilters.add(keyFilter);

    EntityKey entityKey = mock(EntityKey.class);
    when(entityKey.getType()).thenReturn(EntityKeyType.ATTRIBUTE);

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(entityKey);
    entityKeyMapping.setEntityKeyColumn("foo");
    entityKeyMapping.setKeyFilters(keyFilters);

    // Act
    Stream<String> actualToQueriesResult =
        entityKeyMapping.toQueries(
            new QueryContext(
                new QuerySecurityContext(
                    ModelConstants.SYSTEM_TENANT,
                    BaseEntityService.NULL_CUSTOMER_ID,
                    EntityType.TENANT)),
            EntityFilterType.SINGLE_ENTITY);

    // Assert
    verify(entityKey).getType();
    List<String> collectResult = actualToQueriesResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("", collectResult.get(0));
  }

  /**
   * Test {@link EntityKeyMapping#toQueries(QueryContext, EntityFilterType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKey} {@link EntityKey#getType()} return {@code ENTITY_FIELD}.
   *   <li>Then calls {@link EntityKey#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toQueries(QueryContext, EntityFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream EntityKeyMapping.toQueries(QueryContext, EntityFilterType)"})
  public void testToQueries_givenEntityKeyGetTypeReturnEntityField_thenCallsGetType() {
    // Arrange
    ComplexFilterPredicate predicate = new ComplexFilterPredicate();
    predicate.setOperation(ComplexOperation.AND);
    predicate.setPredicates(new ArrayList<>());

    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setValueType(EntityKeyValueType.STRING);
    keyFilter.setPredicate(predicate);
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ENTITY_TYPE));

    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    keyFilters.add(keyFilter);

    EntityKey entityKey = mock(EntityKey.class);
    when(entityKey.getType()).thenReturn(EntityKeyType.ENTITY_FIELD);

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(entityKey);
    entityKeyMapping.setEntityKeyColumn("foo");
    entityKeyMapping.setKeyFilters(keyFilters);

    // Act
    Stream<String> actualToQueriesResult =
        entityKeyMapping.toQueries(
            new QueryContext(
                new QuerySecurityContext(
                    ModelConstants.SYSTEM_TENANT,
                    BaseEntityService.NULL_CUSTOMER_ID,
                    EntityType.TENANT)),
            EntityFilterType.SINGLE_ENTITY);

    // Assert
    verify(entityKey).getType();
    List<String> collectResult = actualToQueriesResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("", collectResult.get(0));
  }

  /**
   * Test {@link EntityKeyMapping#toQueries(QueryContext, EntityFilterType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) EntityKeyColumn is {@code null}.
   *   <li>Then calls {@link EntityKey#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toQueries(QueryContext, EntityFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream EntityKeyMapping.toQueries(QueryContext, EntityFilterType)"})
  public void testToQueries_givenEntityKeyMappingEntityKeyColumnIsNull_thenCallsGetType() {
    // Arrange
    ComplexFilterPredicate predicate = new ComplexFilterPredicate();
    predicate.setOperation(ComplexOperation.AND);
    predicate.setPredicates(new ArrayList<>());

    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setValueType(EntityKeyValueType.STRING);
    keyFilter.setPredicate(predicate);
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ENTITY_TYPE));

    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    keyFilters.add(keyFilter);

    EntityKey entityKey = mock(EntityKey.class);
    when(entityKey.getType()).thenReturn(EntityKeyType.ENTITY_FIELD);

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(entityKey);
    entityKeyMapping.setEntityKeyColumn(null);
    entityKeyMapping.setKeyFilters(keyFilters);

    // Act
    Stream<String> actualToQueriesResult =
        entityKeyMapping.toQueries(
            new QueryContext(
                new QuerySecurityContext(
                    ModelConstants.SYSTEM_TENANT,
                    BaseEntityService.NULL_CUSTOMER_ID,
                    EntityType.TENANT)),
            EntityFilterType.SINGLE_ENTITY);

    // Assert
    verify(entityKey).getType();
    List<String> collectResult = actualToQueriesResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("", collectResult.get(0));
  }

  /**
   * Test {@link EntityKeyMapping#toQueries(QueryContext, EntityFilterType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) EntityKey is {@link
   *       EntityKey#EntityKey(EntityKeyType, String)} with type is {@code ATTRIBUTE} and {@code
   *       Key}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toQueries(QueryContext, EntityFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream EntityKeyMapping.toQueries(QueryContext, EntityFilterType)"})
  public void testToQueries_givenEntityKeyMappingEntityKeyIsEntityKeyWithTypeIsAttributeAndKey() {
    // Arrange
    ComplexFilterPredicate predicate = new ComplexFilterPredicate();
    predicate.setOperation(ComplexOperation.AND);
    predicate.setPredicates(new ArrayList<>());

    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setValueType(EntityKeyValueType.STRING);
    keyFilter.setPredicate(predicate);
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ENTITY_TYPE));

    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    keyFilters.add(keyFilter);

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    entityKeyMapping.setEntityKeyColumn("foo");
    entityKeyMapping.setKeyFilters(keyFilters);

    // Act
    Stream<String> actualToQueriesResult =
        entityKeyMapping.toQueries(
            new QueryContext(
                new QuerySecurityContext(
                    ModelConstants.SYSTEM_TENANT,
                    BaseEntityService.NULL_CUSTOMER_ID,
                    EntityType.TENANT)),
            EntityFilterType.SINGLE_ENTITY);

    // Assert
    List<String> collectResult = actualToQueriesResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("", collectResult.get(0));
  }

  /**
   * Test {@link EntityKeyMapping#toQueries(QueryContext, EntityFilterType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toQueries(QueryContext, EntityFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream EntityKeyMapping.toQueries(QueryContext, EntityFilterType)"})
  public void testToQueries_givenEntityKeyMapping_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();

    // Act
    Stream<String> actualToQueriesResult =
        entityKeyMapping.toQueries(
            new QueryContext(
                new QuerySecurityContext(
                    ModelConstants.SYSTEM_TENANT,
                    BaseEntityService.NULL_CUSTOMER_ID,
                    EntityType.TENANT)),
            EntityFilterType.SINGLE_ENTITY);

    // Assert
    assertTrue(actualToQueriesResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#toQueries(QueryContext, EntityFilterType)}.
   *
   * <ul>
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toQueries(QueryContext, EntityFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream EntityKeyMapping.toQueries(QueryContext, EntityFilterType)"})
  public void testToQueries_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKeyColumn("foo");
    entityKeyMapping.setKeyFilters(new ArrayList<>());

    // Act
    Stream<String> actualToQueriesResult =
        entityKeyMapping.toQueries(
            new QueryContext(
                new QuerySecurityContext(
                    ModelConstants.SYSTEM_TENANT,
                    BaseEntityService.NULL_CUSTOMER_ID,
                    EntityType.TENANT)),
            EntityFilterType.SINGLE_ENTITY);

    // Assert
    assertTrue(actualToQueriesResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}.
   *
   * <p>Method under test: {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String EntityKeyMapping.toLatestJoin(QueryContext, EntityFilter, EntityType)"
  })
  public void testToLatestJoin() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    String actualToLatestJoinResult =
        entityKeyMapping.toLatestJoin(ctx, entityFilter, EntityType.TENANT);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals(
        "left join LATERAL (select * from attribute_kv null WHERE null.entity_id=entities.id  AND null.attribute"
            + "_key=(select key_id from key_dictionary where key = :null_key_id)  ORDER BY null.last_update_ts DESC"
            + " limit 1) as null ON true",
        actualToLatestJoinResult);
    assertArrayEquals(new String[] {"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}.
   *
   * <p>Method under test: {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String EntityKeyMapping.toLatestJoin(QueryContext, EntityFilter, EntityType)"
  })
  public void testToLatestJoin2() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.CLIENT_ATTRIBUTE, "Key"));
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    String actualToLatestJoinResult =
        entityKeyMapping.toLatestJoin(ctx, entityFilter, EntityType.TENANT);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals(
        "left join attribute_kv null ON null.entity_id=entities.id AND null.attribute_key=(select key_id from"
            + " key_dictionary where key = :null_key_id)  AND null.attribute_type=1 ",
        actualToLatestJoinResult);
    assertArrayEquals(new String[] {"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}.
   *
   * <p>Method under test: {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String EntityKeyMapping.toLatestJoin(QueryContext, EntityFilter, EntityType)"
  })
  public void testToLatestJoin3() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.SHARED_ATTRIBUTE, "Key"));
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    String actualToLatestJoinResult =
        entityKeyMapping.toLatestJoin(ctx, entityFilter, EntityType.TENANT);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals(
        "left join attribute_kv null ON null.entity_id=entities.id AND null.attribute_key=(select key_id from"
            + " key_dictionary where key = :null_key_id)  AND null.attribute_type=3 ",
        actualToLatestJoinResult);
    assertArrayEquals(new String[] {"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}.
   *
   * <p>Method under test: {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String EntityKeyMapping.toLatestJoin(QueryContext, EntityFilter, EntityType)"
  })
  public void testToLatestJoin4() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.SERVER_ATTRIBUTE, "Key"));
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    String actualToLatestJoinResult =
        entityKeyMapping.toLatestJoin(ctx, entityFilter, EntityType.TENANT);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals(
        "left join attribute_kv null ON null.entity_id=entities.id AND null.attribute_key=(select key_id from"
            + " key_dictionary where key = :null_key_id)  AND null.attribute_type=2 ",
        actualToLatestJoinResult);
    assertArrayEquals(new String[] {"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}.
   *
   * <p>Method under test: {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String EntityKeyMapping.toLatestJoin(QueryContext, EntityFilter, EntityType)"
  })
  public void testToLatestJoin5() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.TIME_SERIES, "Key"));
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    String actualToLatestJoinResult =
        entityKeyMapping.toLatestJoin(ctx, entityFilter, EntityType.TENANT);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals(
        "left join ts_kv_latest null ON null.entity_id=entities.id AND null.key = (select key_id from key_dictionary"
            + " where key = :null_key_id) ",
        actualToLatestJoinResult);
    assertArrayEquals(new String[] {"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) KeyFilters is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String EntityKeyMapping.toLatestJoin(QueryContext, EntityFilter, EntityType)"
  })
  public void testToLatestJoin_givenEntityKeyMappingKeyFiltersIsArrayList_thenReturnAString() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setKeyFilters(new ArrayList<>());
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    String actualToLatestJoinResult =
        entityKeyMapping.toLatestJoin(ctx, entityFilter, EntityType.TENANT);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals(
        "left join LATERAL (select * from attribute_kv null WHERE null.entity_id=entities.id  AND null.attribute"
            + "_key=(select key_id from key_dictionary where key = :null_key_id)  ORDER BY null.last_update_ts DESC"
            + " limit 1) as null ON true",
        actualToLatestJoinResult);
    assertArrayEquals(new String[] {"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   *
   * <p>Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(
        new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ENTITY_TYPE));
    entityKeyMapping.setEntityKeyColumn("Mappings");
    entityKeyMapping.setSortOrder(false);

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "(coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast(null.long_v"
            + " as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v as varchar),"
            + " '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(
            mappings, EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   *
   * <p>Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections2() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, ", "));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKey(new EntityKey(EntityKeyType.TIME_SERIES, ", "));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping2);
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "(coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast(null.long_v"
            + " as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v as"
            + " varchar), '')) as null_value, null.ts as null_ts, (coalesce(cast(null.bool_v as varchar), '') ||"
            + " coalesce(null.str_v, '') || coalesce(cast(null.long_v as varchar), '') || coalesce(cast(null.dbl_v"
            + " as varchar), '') || coalesce(cast(null.json_v as varchar), '')) as null_value, null.last_update_ts"
            + " as null_ts",
        EntityKeyMapping.buildSelections(
            mappings, EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   *
   * <p>Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections3() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, ", "));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, ", "));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping2);
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "'' as null, (coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast"
            + "(null.long_v as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v"
            + " as varchar), '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(
            mappings, EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   *
   * <p>Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections4() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, ", "));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKey(
        new EntityKey(EntityKeyType.ENTITY_FIELD, EntityKeyMapping.ENTITY_TYPE));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping2);
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "'TENANT' as null, (coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') ||"
            + " coalesce(cast(null.long_v as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') ||"
            + " coalesce(cast(null.json_v as varchar), '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(
            mappings, EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) EntityKeyColumn is {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections_givenEntityKeyMappingEntityKeyColumnIsComma() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, ", "));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKeyColumn(", ");
    entityKeyMapping2.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, ", "));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping2);
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "cast(e.,  as varchar) as null, (coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '')"
            + " || coalesce(cast(null.long_v as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') ||"
            + " coalesce(cast(null.json_v as varchar), '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(
            mappings, EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) Index is one.
   *   <li>When {@code RELATIONS_QUERY}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections_givenEntityKeyMappingIndexIsOne_whenRelationsQuery() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, ", "));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setIndex(1);
    entityKeyMapping2.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, ", "));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping2);
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "'' as null, (coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast"
            + "(null.long_v as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v"
            + " as varchar), '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(
            mappings, EntityFilterType.RELATIONS_QUERY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) Index is one.
   *   <li>When {@code RELATIONS_QUERY}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections_givenEntityKeyMappingIndexIsOne_whenRelationsQuery2() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, ", "));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setIndex(1);
    entityKeyMapping2.setEntityKey(
        new EntityKey(EntityKeyType.ENTITY_FIELD, EntityKeyMapping.ENTITY_TYPE));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping2);
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "'' as null, (coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast"
            + "(null.long_v as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v"
            + " as varchar), '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(
            mappings, EntityFilterType.RELATIONS_QUERY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) SortOrder is {@code true}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections_givenEntityKeyMappingSortOrderIsTrue_thenReturnAString() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, ", "));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setSortOrder(true);
    entityKeyMapping2.setEntityKey(new EntityKey(EntityKeyType.TIME_SERIES, ", "));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping2);
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "(coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast(null.long_v"
            + " as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v as varchar),"
            + " '')) as null_value, null.ts as null_ts, coalesce(null.dbl_v, cast(null.long_v as double precision),"
            + " (case when null.bool_v then 1 else 0 end)) null_value_so_num,coalesce(null.str_v, cast(null.json_v"
            + " as varchar), '') null_value_so_varchar, (coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v,"
            + " '') || coalesce(cast(null.long_v as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') ||"
            + " coalesce(cast(null.json_v as varchar), '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(
            mappings, EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        EntityKeyMapping.buildSelections(
            new ArrayList<>(), EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections_whenNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, ", "));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, ", "));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping2);
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "'' as null, (coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast"
            + "(null.long_v as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v"
            + " as varchar), '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(mappings, EntityFilterType.SINGLE_ENTITY, null));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   *
   * <ul>
   *   <li>When {@code USER}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections_whenUser() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, ", "));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, ", "));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping2);
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "'' as null, (coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast"
            + "(null.long_v as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v"
            + " as varchar), '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(
            mappings, EntityFilterType.SINGLE_ENTITY, EntityType.USER));
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter,
   * EntityType, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"
  })
  public void testBuildLatestJoins_givenEntityKeyMapping_thenReturnEmptyString() {
    // Arrange
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);

    ArrayList<EntityKeyMapping> latestMappings = new ArrayList<>();
    latestMappings.add(new EntityKeyMapping());

    // Act
    String actualBuildLatestJoinsResult =
        EntityKeyMapping.buildLatestJoins(
            ctx, entityFilter, EntityType.TENANT, latestMappings, true);

    // Assert
    assertEquals("", actualBuildLatestJoinsResult);
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter,
   * EntityType, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"
  })
  public void testBuildLatestJoins_givenEntityKeyMapping_thenReturnEmptyString2() {
    // Arrange
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);

    ArrayList<EntityKeyMapping> latestMappings = new ArrayList<>();
    latestMappings.add(new EntityKeyMapping());
    latestMappings.add(new EntityKeyMapping());

    // Act
    String actualBuildLatestJoinsResult =
        EntityKeyMapping.buildLatestJoins(
            ctx, entityFilter, EntityType.TENANT, latestMappings, true);

    // Assert
    assertEquals("", actualBuildLatestJoinsResult);
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter,
   * EntityType, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"
  })
  public void testBuildLatestJoins_thenReturnEmptyString() {
    // Arrange
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setKeyFilters(new ArrayList<>());

    ArrayList<EntityKeyMapping> latestMappings = new ArrayList<>();
    latestMappings.add(entityKeyMapping);

    // Act
    String actualBuildLatestJoinsResult =
        EntityKeyMapping.buildLatestJoins(
            ctx, entityFilter, EntityType.TENANT, latestMappings, true);

    // Assert
    assertEquals("", actualBuildLatestJoinsResult);
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter,
   * EntityType, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"
  })
  public void testBuildLatestJoins_whenArrayList_thenReturnEmptyString() {
    // Arrange
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);

    // Act
    String actualBuildLatestJoinsResult =
        EntityKeyMapping.buildLatestJoins(
            ctx, entityFilter, EntityType.TENANT, new ArrayList<>(), true);

    // Assert
    assertEquals("", actualBuildLatestJoinsResult);
  }

  /**
   * Test {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) KeyFilters is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildQuery(QueryContext, List, EntityFilterType)"})
  public void testBuildQuery_givenEntityKeyMappingKeyFiltersIsArrayList_thenReturnEmptyString() {
    // Arrange
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setKeyFilters(new ArrayList<>());

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals("", EntityKeyMapping.buildQuery(ctx, mappings, EntityFilterType.SINGLE_ENTITY));
  }

  /**
   * Test {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildQuery(QueryContext, List, EntityFilterType)"})
  public void testBuildQuery_givenEntityKeyMapping_thenReturnEmptyString() {
    // Arrange
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(new EntityKeyMapping());

    // Act and Assert
    assertEquals("", EntityKeyMapping.buildQuery(ctx, mappings, EntityFilterType.SINGLE_ENTITY));
  }

  /**
   * Test {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildQuery(QueryContext, List, EntityFilterType)"})
  public void testBuildQuery_givenEntityKeyMapping_thenReturnEmptyString2() {
    // Arrange
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(new EntityKeyMapping());
    mappings.add(new EntityKeyMapping());

    // Act and Assert
    assertEquals("", EntityKeyMapping.buildQuery(ctx, mappings, EntityFilterType.SINGLE_ENTITY));
  }

  /**
   * Test {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.buildQuery(QueryContext, List, EntityFilterType)"})
  public void testBuildQuery_whenArrayList_thenReturnEmptyString() {
    // Arrange
    QueryContext ctx =
        new QueryContext(
            new QuerySecurityContext(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                EntityType.TENANT));

    // Act and Assert
    assertEquals(
        "", EntityKeyMapping.buildQuery(ctx, new ArrayList<>(), EntityFilterType.SINGLE_ENTITY));
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    latestValues.add(new EntityKey(EntityKeyType.ATTRIBUTE, "alias%s"));
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "alias%s");
    latestValues.add(entityKey);
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");
    EntityDataPageLink pageLink =
        new EntityDataPageLink(3, 2, "Text Search", new EntityDataSortOrder(key));
    ArrayList<EntityKey> entityFields = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(3, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(2);
    assertEquals("alias6_value", getResult.getValueAlias());
    assertEquals("alias6_value_so_num", getResult.getSortOrderNumAlias());
    assertEquals("alias6_value_so_varchar", getResult.getSortOrderStrAlias());
    EntityKey entityKey2 = getResult.getEntityKey();
    assertEquals(EntityKeyType.ATTRIBUTE, entityKey2.getType());
    assertTrue(getResult.isLatest());
    assertSame(key, entityKey2);
    assertSame(entityKey, actualPrepareKeyMappingResult.get(1).getEntityKey());
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Given {@link EntityKey#EntityKey(EntityKeyType, String)} with type is {@code
   *       ENTITY_FIELD} and {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_givenEntityKeyWithTypeIsEntityFieldAndKey() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    entityFields.add(new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ADDITIONAL_INFO));
    EntityKey entityKey = new EntityKey(EntityKeyType.ENTITY_FIELD, "Key");
    entityFields.add(entityKey);
    EntityDataPageLink pageLink =
        new EntityDataPageLink(3, 2, "Text Search", new EntityDataSortOrder());
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(1);
    assertEquals("alias4", getResult.getValueAlias());
    assertEquals("alias4_so_num", getResult.getSortOrderNumAlias());
    assertEquals("alias4_so_varchar", getResult.getSortOrderStrAlias());
    EntityKey entityKey2 = getResult.getEntityKey();
    assertEquals(EntityKeyType.ENTITY_FIELD, entityKey2.getType());
    assertSame(entityKey, entityKey2);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnEmpty() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertTrue(actualPrepareKeyMappingResult.isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnEmpty2() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink =
        new EntityDataPageLink(3, 2, "Text Search", new EntityDataSortOrder());
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertTrue(actualPrepareKeyMappingResult.isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return first EntityKeyColumn is {@code additional_info}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnFirstEntityKeyColumnIsAdditionalInfo() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ADDITIONAL_INFO);
    entityFields.add(entityKey);
    entityFields.add(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(0);
    assertEquals("additional_info", getResult.getEntityKeyColumn());
    assertFalse(actualPrepareKeyMappingResult.get(1).isLatest());
    EntityKey entityKey2 = getResult.getEntityKey();
    assertEquals(EntityKeyMapping.ADDITIONAL_INFO, entityKey2.getKey());
    assertSame(entityKey, entityKey2);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return first EntityKey Key is {@code alias%s}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnFirstEntityKeyKeyIsAliasS() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "alias%s");
    latestValues.add(entityKey);
    EntityDataPageLink pageLink =
        new EntityDataPageLink(
            3,
            2,
            "Text Search",
            new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key")));
    ArrayList<EntityKey> entityFields = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKey entityKey2 = actualPrepareKeyMappingResult.get(0).getEntityKey();
    assertEquals("alias%s", entityKey2.getKey());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(1);
    assertTrue(getResult.isIgnore());
    assertTrue(getResult.isSortOrder());
    assertSame(entityKey, entityKey2);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return first KeyFilters is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnFirstKeyFiltersIsArrayList() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    keyFilters.add(keyFilter);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, new ArrayList<>(), keyFilters);

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(1, actualPrepareKeyMappingResult.size());
    assertEquals(keyFilters, actualPrepareKeyMappingResult.get(0).getKeyFilters());
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return first KeyFilters size is two.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnFirstKeyFiltersSizeIsTwo() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.NUMERIC);

    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    keyFilters.add(keyFilter2);
    keyFilters.add(keyFilter);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, new ArrayList<>(), keyFilters);

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(1, actualPrepareKeyMappingResult.size());
    List<KeyFilter> keyFilters2 = actualPrepareKeyMappingResult.get(0).getKeyFilters();
    assertEquals(2, keyFilters2.size());
    assertEquals(EntityKeyValueType.NUMERIC, keyFilters2.get(0).getValueType());
    assertSame(keyFilter, keyFilters2.get(1));
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return first Latest.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnFirstLatest() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");
    latestValues.add(entityKey);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(1, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(0);
    EntityKey entityKey2 = getResult.getEntityKey();
    assertEquals("Key", entityKey2.getKey());
    assertTrue(getResult.isLatest());
    assertTrue(getResult.isSearchable());
    assertSame(entityKey, entityKey2);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return first SortOrder.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnFirstSortOrder() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");
    latestValues.add(entityKey);
    EntityDataPageLink pageLink =
        new EntityDataPageLink(
            3,
            2,
            "Text Search",
            new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key")));
    ArrayList<EntityKey> entityFields = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(1, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(0);
    assertTrue(getResult.isSortOrder());
    assertSame(entityKey, getResult.getEntityKey());
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return first ValueAlias is {@code alias2}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnFirstValueAliasIsAlias2() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    latestValues.add(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    EntityKey key = new EntityKey(EntityKeyType.ENTITY_FIELD, "Key");
    EntityDataPageLink pageLink =
        new EntityDataPageLink(3, 2, "Text Search", new EntityDataSortOrder(key));
    ArrayList<EntityKey> entityFields = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(0);
    assertEquals("alias2", getResult.getValueAlias());
    assertEquals("alias2_so_num", getResult.getSortOrderNumAlias());
    assertEquals("alias2_so_varchar", getResult.getSortOrderStrAlias());
    EntityKeyMapping getResult2 = actualPrepareKeyMappingResult.get(1);
    assertEquals("alias3", getResult2.getAlias());
    assertEquals("alias3_ts", getResult2.getTsAlias());
    assertEquals("alias3_value", getResult2.getValueAlias());
    assertEquals("alias3_value_so_num", getResult2.getSortOrderNumAlias());
    assertEquals("alias3_value_so_varchar", getResult2.getSortOrderStrAlias());
    assertEquals(3, getResult2.getIndex());
    assertSame(key, getResult.getEntityKey());
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return not first Latest.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnNotFirstLatest() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");
    entityFields.add(entityKey);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(1, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(0);
    EntityKey entityKey2 = getResult.getEntityKey();
    assertEquals("Key", entityKey2.getKey());
    assertFalse(getResult.isLatest());
    assertTrue(getResult.isSearchable());
    assertSame(entityKey, entityKey2);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return not first Searchable.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnNotFirstSearchable() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");
    EntityDataPageLink pageLink =
        new EntityDataPageLink(3, 2, "Text Search", new EntityDataSortOrder(key));
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(1, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(0);
    assertFalse(getResult.isSearchable());
    assertTrue(getResult.isIgnore());
    assertTrue(getResult.isSortOrder());
    assertSame(key, getResult.getEntityKey());
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return second EntityKeyColumn is {@code additional_info}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnSecondEntityKeyColumnIsAdditionalInfo() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    entityFields.add(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    KeyFilter keyFilter = new KeyFilter();
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ADDITIONAL_INFO);
    keyFilter.setKey(key);
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.NUMERIC);

    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    keyFilters.add(keyFilter);
    EntityDataPageLink pageLink = new EntityDataPageLink();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, new ArrayList<>(), keyFilters);

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(1);
    assertEquals("additional_info", getResult.getEntityKeyColumn());
    assertFalse(getResult.isSelection());
    assertEquals(keyFilters, getResult.getKeyFilters());
    EntityKey entityKey = getResult.getEntityKey();
    assertEquals(EntityKeyMapping.ADDITIONAL_INFO, entityKey.getKey());
    assertSame(key, entityKey);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return second EntityKey Key is {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnSecondEntityKeyKeyIsKey() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    latestValues.add(new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ADDITIONAL_INFO));
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");
    latestValues.add(entityKey);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(1);
    EntityKey entityKey2 = getResult.getEntityKey();
    assertEquals("Key", entityKey2.getKey());
    assertEquals("alias4_value", getResult.getValueAlias());
    assertEquals("alias4_value_so_num", getResult.getSortOrderNumAlias());
    assertEquals("alias4_value_so_varchar", getResult.getSortOrderStrAlias());
    assertTrue(getResult.isLatest());
    assertTrue(getResult.isSearchable());
    assertSame(entityKey, entityKey2);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return second EntityKey Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnSecondEntityKeyKeyIsNull() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ADDITIONAL_INFO);
    latestValues.add(entityKey);
    EntityKey entityKey2 = new EntityKey(EntityKeyType.ATTRIBUTE, null);
    latestValues.add(entityKey2);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKey entityKey3 = actualPrepareKeyMappingResult.get(1).getEntityKey();
    assertNull(entityKey3.getKey());
    EntityKey entityKey4 = actualPrepareKeyMappingResult.get(0).getEntityKey();
    assertEquals(EntityKeyMapping.ADDITIONAL_INFO, entityKey4.getKey());
    assertSame(entityKey2, entityKey3);
    assertSame(entityKey, entityKey4);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return second ValueAlias is {@code alias4}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnSecondValueAliasIsAlias4() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    entityFields.add(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    EntityKey key = new EntityKey(EntityKeyType.ENTITY_FIELD, "Key");
    EntityDataPageLink pageLink =
        new EntityDataPageLink(3, 2, "Text Search", new EntityDataSortOrder(key));
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(1);
    assertEquals("alias4", getResult.getValueAlias());
    assertEquals("alias4_so_num", getResult.getSortOrderNumAlias());
    assertEquals("alias4_so_varchar", getResult.getSortOrderStrAlias());
    EntityKey entityKey = getResult.getEntityKey();
    assertEquals(EntityKeyType.ENTITY_FIELD, entityKey.getType());
    assertTrue(getResult.isIgnore());
    assertTrue(getResult.isSortOrder());
    assertSame(key, entityKey);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return third ValueAlias is {@code alias6}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnThirdValueAliasIsAlias6() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    entityFields.add(new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ADDITIONAL_INFO));
    entityFields.add(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    EntityKey key = new EntityKey(EntityKeyType.ENTITY_FIELD, "Key");
    EntityDataPageLink pageLink =
        new EntityDataPageLink(3, 2, "Text Search", new EntityDataSortOrder(key));
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(3, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(2);
    assertEquals("alias6", getResult.getValueAlias());
    assertEquals("alias6_so_num", getResult.getSortOrderNumAlias());
    assertEquals("alias6_so_varchar", getResult.getSortOrderStrAlias());
    EntityKey entityKey = getResult.getEntityKey();
    assertEquals(EntityKeyType.ENTITY_FIELD, entityKey.getType());
    assertFalse(getResult.isLatest());
    assertSame(key, entityKey);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return third ValueAlias is {@code alias6_value}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnThirdValueAliasIsAlias6Value() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    latestValues.add(new EntityKey(EntityKeyType.ATTRIBUTE, "alias%s"));
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, null);
    latestValues.add(entityKey);
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");
    EntityDataPageLink pageLink =
        new EntityDataPageLink(3, 2, "Text Search", new EntityDataSortOrder(key));
    ArrayList<EntityKey> entityFields = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult =
        EntityKeyMapping.prepareKeyMapping(EntityType.TENANT, query);

    // Assert
    verify(entityFilter).getType();
    assertEquals(3, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(2);
    assertEquals("alias6_value", getResult.getValueAlias());
    assertEquals("alias6_value_so_num", getResult.getSortOrderNumAlias());
    assertEquals("alias6_value_so_varchar", getResult.getSortOrderStrAlias());
    EntityKey entityKey2 = actualPrepareKeyMappingResult.get(1).getEntityKey();
    assertNull(entityKey2.getKey());
    EntityKey entityKey3 = getResult.getEntityKey();
    assertEquals(EntityKeyType.ATTRIBUTE, entityKey3.getType());
    assertTrue(getResult.isLatest());
    assertSame(key, entityKey3);
    assertSame(entityKey, entityKey2);
  }

  /**
   * Test {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}.
   *
   * <ul>
   *   <li>Given {@code API_USAGE_STATE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareEntityCountKeyMapping(EntityCountQuery)"})
  public void testPrepareEntityCountKeyMapping_givenApiUsageState() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.API_USAGE_STATE);
    EntityCountQuery query = new EntityCountQuery(entityFilter, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareEntityCountKeyMappingResult =
        EntityKeyMapping.prepareEntityCountKeyMapping(query);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertTrue(actualPrepareEntityCountKeyMappingResult.isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}.
   *
   * <ul>
   *   <li>Given {@code ASSET_SEARCH_QUERY}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareEntityCountKeyMapping(EntityCountQuery)"})
  public void testPrepareEntityCountKeyMapping_givenAssetSearchQuery() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.ASSET_SEARCH_QUERY);
    EntityCountQuery query = new EntityCountQuery(entityFilter, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareEntityCountKeyMappingResult =
        EntityKeyMapping.prepareEntityCountKeyMapping(query);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertTrue(actualPrepareEntityCountKeyMappingResult.isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}.
   *
   * <ul>
   *   <li>Given {@code DEVICE_SEARCH_QUERY}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareEntityCountKeyMapping(EntityCountQuery)"})
  public void testPrepareEntityCountKeyMapping_givenDeviceSearchQuery() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.DEVICE_SEARCH_QUERY);
    EntityCountQuery query = new EntityCountQuery(entityFilter, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareEntityCountKeyMappingResult =
        EntityKeyMapping.prepareEntityCountKeyMapping(query);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertTrue(actualPrepareEntityCountKeyMappingResult.isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}.
   *
   * <ul>
   *   <li>Given {@code EDGE_SEARCH_QUERY}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareEntityCountKeyMapping(EntityCountQuery)"})
  public void testPrepareEntityCountKeyMapping_givenEdgeSearchQuery() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.EDGE_SEARCH_QUERY);
    EntityCountQuery query = new EntityCountQuery(entityFilter, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareEntityCountKeyMappingResult =
        EntityKeyMapping.prepareEntityCountKeyMapping(query);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertTrue(actualPrepareEntityCountKeyMappingResult.isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}.
   *
   * <ul>
   *   <li>Given {@code ENTITY_VIEW_SEARCH_QUERY}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityKeyMapping.prepareEntityCountKeyMapping(EntityCountQuery)"})
  public void testPrepareEntityCountKeyMapping_givenEntityViewSearchQuery() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.ENTITY_VIEW_SEARCH_QUERY);
    EntityCountQuery query = new EntityCountQuery(entityFilter, new ArrayList<>());

    // Act
    List<EntityKeyMapping> actualPrepareEntityCountKeyMappingResult =
        EntityKeyMapping.prepareEntityCountKeyMapping(query);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertTrue(actualPrepareEntityCountKeyMappingResult.isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#getSortOrderStrAlias()}.
   *
   * <ul>
   *   <li>Then return {@code null_so_varchar}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#getSortOrderStrAlias()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.getSortOrderStrAlias()"})
  public void testGetSortOrderStrAlias_thenReturnNullSoVarchar() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "Key"));

    // Act and Assert
    assertEquals("null_so_varchar", entityKeyMapping.getSortOrderStrAlias());
  }

  /**
   * Test {@link EntityKeyMapping#getSortOrderStrAlias()}.
   *
   * <ul>
   *   <li>Then return {@code null_value_so_varchar}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#getSortOrderStrAlias()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.getSortOrderStrAlias()"})
  public void testGetSortOrderStrAlias_thenReturnNullValueSoVarchar() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertEquals("null_value_so_varchar", entityKeyMapping.getSortOrderStrAlias());
  }

  /**
   * Test {@link EntityKeyMapping#getSortOrderNumAlias()}.
   *
   * <ul>
   *   <li>Then return {@code null_so_num}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#getSortOrderNumAlias()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.getSortOrderNumAlias()"})
  public void testGetSortOrderNumAlias_thenReturnNullSoNum() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "Key"));

    // Act and Assert
    assertEquals("null_so_num", entityKeyMapping.getSortOrderNumAlias());
  }

  /**
   * Test {@link EntityKeyMapping#getSortOrderNumAlias()}.
   *
   * <ul>
   *   <li>Then return {@code null_value_so_num}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#getSortOrderNumAlias()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyMapping.getSortOrderNumAlias()"})
  public void testGetSortOrderNumAlias_thenReturnNullValueSoNum() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertEquals("null_value_so_num", entityKeyMapping.getSortOrderNumAlias());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}, and {@link EntityKeyMapping#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityKeyMapping#equals(Object)}
   *   <li>{@link EntityKeyMapping#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();

    // Act and Assert
    assertEquals(entityKeyMapping, entityKeyMapping2);
    assertEquals(entityKeyMapping.hashCode(), entityKeyMapping2.hashCode());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}, and {@link EntityKeyMapping#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityKeyMapping#equals(Object)}
   *   <li>{@link EntityKeyMapping#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setAlias("Alias");

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setAlias("Alias");

    // Act and Assert
    assertEquals(entityKeyMapping, entityKeyMapping2);
    assertEquals(entityKeyMapping.hashCode(), entityKeyMapping2.hashCode());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}, and {@link EntityKeyMapping#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityKeyMapping#equals(Object)}
   *   <li>{@link EntityKeyMapping#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKeyColumn("Entity Key Column");

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKeyColumn("Entity Key Column");

    // Act and Assert
    assertEquals(entityKeyMapping, entityKeyMapping2);
    assertEquals(entityKeyMapping.hashCode(), entityKeyMapping2.hashCode());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}, and {@link EntityKeyMapping#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityKeyMapping#equals(Object)}
   *   <li>{@link EntityKeyMapping#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setKeyFilters(new ArrayList<>());

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setKeyFilters(new ArrayList<>());

    // Act and Assert
    assertEquals(entityKeyMapping, entityKeyMapping2);
    assertEquals(entityKeyMapping.hashCode(), entityKeyMapping2.hashCode());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}, and {@link EntityKeyMapping#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityKeyMapping#equals(Object)}
   *   <li>{@link EntityKeyMapping#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertEquals(entityKeyMapping, entityKeyMapping2);
    assertEquals(entityKeyMapping.hashCode(), entityKeyMapping2.hashCode());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}, and {@link EntityKeyMapping#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityKeyMapping#equals(Object)}
   *   <li>{@link EntityKeyMapping#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();

    // Act and Assert
    assertEquals(entityKeyMapping, entityKeyMapping);
    int expectedHashCodeResult = entityKeyMapping.hashCode();
    assertEquals(expectedHashCodeResult, entityKeyMapping.hashCode());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityKeyMapping(), 1);
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setIndex(1);

    // Act and Assert
    assertNotEquals(entityKeyMapping, new EntityKeyMapping());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setAlias("Alias");

    // Act and Assert
    assertNotEquals(entityKeyMapping, new EntityKeyMapping());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setLatest(true);

    // Act and Assert
    assertNotEquals(entityKeyMapping, new EntityKeyMapping());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKeyColumn("Entity Key Column");

    // Act and Assert
    assertNotEquals(entityKeyMapping, new EntityKeyMapping());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setSelection(true);

    // Act and Assert
    assertNotEquals(entityKeyMapping, new EntityKeyMapping());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setSearchable(true);

    // Act and Assert
    assertNotEquals(entityKeyMapping, new EntityKeyMapping());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setSortOrder(true);

    // Act and Assert
    assertNotEquals(entityKeyMapping, new EntityKeyMapping());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setIgnore(true);

    // Act and Assert
    assertNotEquals(entityKeyMapping, new EntityKeyMapping());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setKeyFilters(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityKeyMapping, new EntityKeyMapping());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertNotEquals(entityKeyMapping, new EntityKeyMapping());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setParamIdx(1);

    // Act and Assert
    assertNotEquals(entityKeyMapping, new EntityKeyMapping());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setAlias("Alias");

    // Act and Assert
    assertNotEquals(entityKeyMapping, entityKeyMapping2);
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKeyColumn("Entity Key Column");

    // Act and Assert
    assertNotEquals(entityKeyMapping, entityKeyMapping2);
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setKeyFilters(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityKeyMapping, entityKeyMapping2);
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertNotEquals(entityKeyMapping, entityKeyMapping2);
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityKeyMapping(), null);
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityKeyMapping(), "Different type to EntityKeyMapping");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityKeyMapping}
   *   <li>{@link EntityKeyMapping#setAlias(String)}
   *   <li>{@link EntityKeyMapping#setEntityKey(EntityKey)}
   *   <li>{@link EntityKeyMapping#setEntityKeyColumn(String)}
   *   <li>{@link EntityKeyMapping#setIgnore(boolean)}
   *   <li>{@link EntityKeyMapping#setIndex(int)}
   *   <li>{@link EntityKeyMapping#setKeyFilters(List)}
   *   <li>{@link EntityKeyMapping#setLatest(boolean)}
   *   <li>{@link EntityKeyMapping#setParamIdx(int)}
   *   <li>{@link EntityKeyMapping#setSearchable(boolean)}
   *   <li>{@link EntityKeyMapping#setSelection(boolean)}
   *   <li>{@link EntityKeyMapping#setSortOrder(boolean)}
   *   <li>{@link EntityKeyMapping#toString()}
   *   <li>{@link EntityKeyMapping#getAlias()}
   *   <li>{@link EntityKeyMapping#getEntityKey()}
   *   <li>{@link EntityKeyMapping#getEntityKeyColumn()}
   *   <li>{@link EntityKeyMapping#getIndex()}
   *   <li>{@link EntityKeyMapping#getKeyFilters()}
   *   <li>{@link EntityKeyMapping#getParamIdx()}
   *   <li>{@link EntityKeyMapping#isIgnore()}
   *   <li>{@link EntityKeyMapping#isLatest()}
   *   <li>{@link EntityKeyMapping#isSearchable()}
   *   <li>{@link EntityKeyMapping#isSelection()}
   *   <li>{@link EntityKeyMapping#isSortOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityKeyMapping.<init>()",
    "String EntityKeyMapping.getAlias()",
    "EntityKey EntityKeyMapping.getEntityKey()",
    "String EntityKeyMapping.getEntityKeyColumn()",
    "int EntityKeyMapping.getIndex()",
    "List EntityKeyMapping.getKeyFilters()",
    "int EntityKeyMapping.getParamIdx()",
    "boolean EntityKeyMapping.isIgnore()",
    "boolean EntityKeyMapping.isLatest()",
    "boolean EntityKeyMapping.isSearchable()",
    "boolean EntityKeyMapping.isSelection()",
    "boolean EntityKeyMapping.isSortOrder()",
    "void EntityKeyMapping.setAlias(String)",
    "void EntityKeyMapping.setEntityKey(EntityKey)",
    "void EntityKeyMapping.setEntityKeyColumn(String)",
    "void EntityKeyMapping.setIgnore(boolean)",
    "void EntityKeyMapping.setIndex(int)",
    "void EntityKeyMapping.setKeyFilters(List)",
    "void EntityKeyMapping.setLatest(boolean)",
    "void EntityKeyMapping.setParamIdx(int)",
    "void EntityKeyMapping.setSearchable(boolean)",
    "void EntityKeyMapping.setSelection(boolean)",
    "void EntityKeyMapping.setSortOrder(boolean)",
    "String EntityKeyMapping.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityKeyMapping actualEntityKeyMapping = new EntityKeyMapping();
    actualEntityKeyMapping.setAlias("Alias");
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");
    actualEntityKeyMapping.setEntityKey(entityKey);
    actualEntityKeyMapping.setEntityKeyColumn("Entity Key Column");
    actualEntityKeyMapping.setIgnore(true);
    actualEntityKeyMapping.setIndex(1);
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    actualEntityKeyMapping.setKeyFilters(keyFilters);
    actualEntityKeyMapping.setLatest(true);
    actualEntityKeyMapping.setParamIdx(1);
    actualEntityKeyMapping.setSearchable(true);
    actualEntityKeyMapping.setSelection(true);
    actualEntityKeyMapping.setSortOrder(true);
    String actualToStringResult = actualEntityKeyMapping.toString();
    String actualAlias = actualEntityKeyMapping.getAlias();
    EntityKey actualEntityKey = actualEntityKeyMapping.getEntityKey();
    String actualEntityKeyColumn = actualEntityKeyMapping.getEntityKeyColumn();
    int actualIndex = actualEntityKeyMapping.getIndex();
    List<KeyFilter> actualKeyFilters = actualEntityKeyMapping.getKeyFilters();
    int actualParamIdx = actualEntityKeyMapping.getParamIdx();
    boolean actualIsIgnoreResult = actualEntityKeyMapping.isIgnore();
    boolean actualIsLatestResult = actualEntityKeyMapping.isLatest();
    boolean actualIsSearchableResult = actualEntityKeyMapping.isSearchable();
    boolean actualIsSelectionResult = actualEntityKeyMapping.isSelection();
    boolean actualIsSortOrderResult = actualEntityKeyMapping.isSortOrder();

    // Assert
    assertEquals("Alias", actualAlias);
    assertEquals("Entity Key Column", actualEntityKeyColumn);
    assertEquals(
        "EntityKeyMapping(index=1, alias=Alias, isLatest=true, entityKeyColumn=Entity Key Column, isSelection=true,"
            + " isSearchable=true, isSortOrder=true, ignore=true, keyFilters=[], entityKey=EntityKey(type=ATTRIBUTE,"
            + " key=Key), paramIdx=1)",
        actualToStringResult);
    assertEquals(1, actualIndex);
    assertEquals(1, actualParamIdx);
    assertTrue(actualKeyFilters.isEmpty());
    assertTrue(actualIsIgnoreResult);
    assertTrue(actualIsLatestResult);
    assertTrue(actualIsSearchableResult);
    assertTrue(actualIsSelectionResult);
    assertTrue(actualIsSortOrderResult);
    assertSame(keyFilters, actualKeyFilters);
    assertSame(entityKey, actualEntityKey);
  }
}
