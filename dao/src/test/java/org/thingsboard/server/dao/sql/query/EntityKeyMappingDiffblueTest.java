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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
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
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) KeyFilters is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#hasFilter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#hasFilter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityKeyMapping.hasFilter()"})
  public void testHasFilter_givenEntityKeyMapping_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new EntityKeyMapping()).hasFilter());
  }

  /**
   * Test {@link EntityKeyMapping#hasFilter()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#hasFilter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#getValueAlias()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then return {@code null_value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#getValueAlias()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link EntityKeyMapping#getTsAlias()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.getTsAlias()"})
  public void testGetTsAlias() {
    // Arrange, Act and Assert
    assertEquals("null_ts", (new EntityKeyMapping()).getTsAlias());
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertEquals(
        "(coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast(null.long_v"
            + " as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v as varchar),"
            + " '')) as null_value, null.last_update_ts as null_ts",
        entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection2() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.TIME_SERIES, "Key"));

    // Act and Assert
    assertEquals(
        "(coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast(null.long_v"
            + " as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v as varchar),"
            + " '')) as null_value, null.ts as null_ts",
        entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) SortOrder is {@code true}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_givenEntityKeyMappingSortOrderIsTrue_thenReturnAString() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setSortOrder(true);
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.TIME_SERIES, "Key"));

    // Act and Assert
    assertEquals(
        "(coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast(null.long_v"
            + " as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v as varchar),"
            + " '')) as null_value, null.ts as null_ts, coalesce(null.dbl_v, cast(null.long_v as double precision),"
            + " (case when null.bool_v then 1 else 0 end)) null_value_so_num,coalesce(null.str_v, cast(null.json_v"
            + " as varchar), '') null_value_so_varchar",
        entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   * <ul>
   *   <li>Then return {@code '' as null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_thenReturnAsNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "Key"));

    // Act and Assert
    assertEquals("'' as null", entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   * <ul>
   *   <li>Then return {@code cast(e.entityType as varchar) as null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_thenReturnCastEEntityTypeAsVarcharAsNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKeyColumn(EntityKeyMapping.ENTITY_TYPE);
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "Key"));

    // Act and Assert
    assertEquals("cast(e.entityType as varchar) as null",
        entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   * <ul>
   *   <li>Then return {@code 'TENANT' as null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_thenReturnTenantAsNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, EntityKeyMapping.ENTITY_TYPE));

    // Act and Assert
    assertEquals("'TENANT' as null", entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code '' as null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_whenNull_thenReturnAsNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "Key"));

    // Act and Assert
    assertEquals("'' as null", entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, null));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   * <ul>
   *   <li>When {@code RELATIONS_QUERY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_whenRelationsQuery() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, EntityKeyMapping.ENTITY_TYPE));

    // Act and Assert
    assertEquals("'' as null", entityKeyMapping.toSelection(EntityFilterType.RELATIONS_QUERY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   * <ul>
   *   <li>When {@code RELATIONS_QUERY}.</li>
   *   <li>Then return {@code '' as null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_whenRelationsQuery_thenReturnAsNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "Key"));

    // Act and Assert
    assertEquals("'' as null", entityKeyMapping.toSelection(EntityFilterType.RELATIONS_QUERY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}.
   * <ul>
   *   <li>When {@code USER}.</li>
   *   <li>Then return {@code '' as null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#toSelection(EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toSelection(EntityFilterType, EntityType)"})
  public void testToSelection_whenUser_thenReturnAsNull() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "Key"));

    // Act and Assert
    assertEquals("'' as null", entityKeyMapping.toSelection(EntityFilterType.SINGLE_ENTITY, EntityType.USER));
  }

  /**
   * Test {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toLatestJoin(QueryContext, EntityFilter, EntityType)"})
  public void testToLatestJoin() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    String actualToLatestJoinResult = entityKeyMapping.toLatestJoin(ctx, entityFilter, EntityType.TENANT);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals(
        "left join LATERAL (select * from attribute_kv null WHERE null.entity_id=entities.id  AND null.attribute"
            + "_key=(select key_id from key_dictionary where key = :null_key_id)  ORDER BY null.last_update_ts DESC"
            + " limit 1) as null ON true",
        actualToLatestJoinResult);
    assertArrayEquals(new String[]{"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toLatestJoin(QueryContext, EntityFilter, EntityType)"})
  public void testToLatestJoin2() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.CLIENT_ATTRIBUTE, "Key"));
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    String actualToLatestJoinResult = entityKeyMapping.toLatestJoin(ctx, entityFilter, EntityType.TENANT);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals("left join attribute_kv null ON null.entity_id=entities.id AND null.attribute_key=(select key_id from"
        + " key_dictionary where key = :null_key_id)  AND null.attribute_type=1 ", actualToLatestJoinResult);
    assertArrayEquals(new String[]{"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toLatestJoin(QueryContext, EntityFilter, EntityType)"})
  public void testToLatestJoin3() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.SHARED_ATTRIBUTE, "Key"));
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    String actualToLatestJoinResult = entityKeyMapping.toLatestJoin(ctx, entityFilter, EntityType.TENANT);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals("left join attribute_kv null ON null.entity_id=entities.id AND null.attribute_key=(select key_id from"
        + " key_dictionary where key = :null_key_id)  AND null.attribute_type=3 ", actualToLatestJoinResult);
    assertArrayEquals(new String[]{"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toLatestJoin(QueryContext, EntityFilter, EntityType)"})
  public void testToLatestJoin4() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.SERVER_ATTRIBUTE, "Key"));
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    String actualToLatestJoinResult = entityKeyMapping.toLatestJoin(ctx, entityFilter, EntityType.TENANT);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals("left join attribute_kv null ON null.entity_id=entities.id AND null.attribute_key=(select key_id from"
        + " key_dictionary where key = :null_key_id)  AND null.attribute_type=2 ", actualToLatestJoinResult);
    assertArrayEquals(new String[]{"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toLatestJoin(QueryContext, EntityFilter, EntityType)"})
  public void testToLatestJoin5() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.TIME_SERIES, "Key"));
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    String actualToLatestJoinResult = entityKeyMapping.toLatestJoin(ctx, entityFilter, EntityType.TENANT);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals(
        "left join ts_kv_latest null ON null.entity_id=entities.id AND null.key = (select key_id from key_dictionary"
            + " where key = :null_key_id) ",
        actualToLatestJoinResult);
    assertArrayEquals(new String[]{"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#toLatestJoin(QueryContext, EntityFilter, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.toLatestJoin(QueryContext, EntityFilter, EntityType)"})
  public void testToLatestJoin6() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setKeyFilters(new ArrayList<>());
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.CLIENT_ATTRIBUTE, "Key"));
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    String actualToLatestJoinResult = entityKeyMapping.toLatestJoin(ctx, entityFilter, EntityType.TENANT);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals("left join attribute_kv null ON null.entity_id=entities.id AND null.attribute_key=(select key_id from"
        + " key_dictionary where key = :null_key_id)  AND null.attribute_type=1 ", actualToLatestJoinResult);
    assertArrayEquals(new String[]{"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections() {
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
        EntityKeyMapping.buildSelections(mappings, EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections2() {
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
        EntityKeyMapping.buildSelections(mappings, EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections3() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, ", "));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, EntityKeyMapping.ENTITY_TYPE));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping2);
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "'TENANT' as null, (coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') ||"
            + " coalesce(cast(null.long_v as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') ||"
            + " coalesce(cast(null.json_v as varchar), '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(mappings, EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) EntityKeyColumn is {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
        EntityKeyMapping.buildSelections(mappings, EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) SortOrder is {@code true}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    assertEquals("(coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast(null.long_v"
        + " as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v as varchar),"
        + " '')) as null_value, null.ts as null_ts, coalesce(null.dbl_v, cast(null.long_v as double precision),"
        + " (case when null.bool_v then 1 else 0 end)) null_value_so_num,coalesce(null.str_v, cast(null.json_v"
        + " as varchar), '') null_value_so_varchar, (coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v,"
        + " '') || coalesce(cast(null.long_v as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') ||"
        + " coalesce(cast(null.json_v as varchar), '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(mappings, EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections_thenReturnAString() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, ", "));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "(coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast(null.long_v"
            + " as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v as varchar),"
            + " '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(mappings, EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("",
        EntityKeyMapping.buildSelections(new ArrayList<>(), EntityFilterType.SINGLE_ENTITY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@code RELATIONS_QUERY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections_whenRelationsQuery() {
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
        EntityKeyMapping.buildSelections(mappings, EntityFilterType.RELATIONS_QUERY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   * <ul>
   *   <li>When {@code RELATIONS_QUERY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildSelections(List, EntityFilterType, EntityType)"})
  public void testBuildSelections_whenRelationsQuery2() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, ", "));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKey(new EntityKey(EntityKeyType.ENTITY_FIELD, EntityKeyMapping.ENTITY_TYPE));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping2);
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals(
        "'' as null, (coalesce(cast(null.bool_v as varchar), '') || coalesce(null.str_v, '') || coalesce(cast"
            + "(null.long_v as varchar), '') || coalesce(cast(null.dbl_v as varchar), '') || coalesce(cast(null.json_v"
            + " as varchar), '')) as null_value, null.last_update_ts as null_ts",
        EntityKeyMapping.buildSelections(mappings, EntityFilterType.RELATIONS_QUERY, EntityType.TENANT));
  }

  /**
   * Test {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}.
   * <ul>
   *   <li>When {@code USER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildSelections(List, EntityFilterType, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
        EntityKeyMapping.buildSelections(mappings, EntityFilterType.SINGLE_ENTITY, EntityType.USER));
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"})
  public void testBuildLatestJoins() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, " "));

    ArrayList<EntityKeyMapping> latestMappings = new ArrayList<>();
    latestMappings.add(entityKeyMapping);

    // Act
    String actualBuildLatestJoinsResult = EntityKeyMapping.buildLatestJoins(ctx, entityFilter, EntityType.TENANT,
        latestMappings, false);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals(
        "left join LATERAL (select * from attribute_kv null WHERE null.entity_id=entities.id  AND null.attribute"
            + "_key=(select key_id from key_dictionary where key = :null_key_id)  ORDER BY null.last_update_ts DESC"
            + " limit 1) as null ON true",
        actualBuildLatestJoinsResult);
    assertArrayEquals(new String[]{"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"})
  public void testBuildLatestJoins2() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.CLIENT_ATTRIBUTE, " "));

    ArrayList<EntityKeyMapping> latestMappings = new ArrayList<>();
    latestMappings.add(entityKeyMapping);

    // Act
    String actualBuildLatestJoinsResult = EntityKeyMapping.buildLatestJoins(ctx, entityFilter, EntityType.TENANT,
        latestMappings, false);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals("left join attribute_kv null ON null.entity_id=entities.id AND null.attribute_key=(select key_id from"
        + " key_dictionary where key = :null_key_id)  AND null.attribute_type=1 ", actualBuildLatestJoinsResult);
    assertArrayEquals(new String[]{"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"})
  public void testBuildLatestJoins3() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.SHARED_ATTRIBUTE, " "));

    ArrayList<EntityKeyMapping> latestMappings = new ArrayList<>();
    latestMappings.add(entityKeyMapping);

    // Act
    String actualBuildLatestJoinsResult = EntityKeyMapping.buildLatestJoins(ctx, entityFilter, EntityType.TENANT,
        latestMappings, false);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals("left join attribute_kv null ON null.entity_id=entities.id AND null.attribute_key=(select key_id from"
        + " key_dictionary where key = :null_key_id)  AND null.attribute_type=3 ", actualBuildLatestJoinsResult);
    assertArrayEquals(new String[]{"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"})
  public void testBuildLatestJoins4() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.SERVER_ATTRIBUTE, " "));

    ArrayList<EntityKeyMapping> latestMappings = new ArrayList<>();
    latestMappings.add(entityKeyMapping);

    // Act
    String actualBuildLatestJoinsResult = EntityKeyMapping.buildLatestJoins(ctx, entityFilter, EntityType.TENANT,
        latestMappings, false);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals("left join attribute_kv null ON null.entity_id=entities.id AND null.attribute_key=(select key_id from"
        + " key_dictionary where key = :null_key_id)  AND null.attribute_type=2 ", actualBuildLatestJoinsResult);
    assertArrayEquals(new String[]{"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"})
  public void testBuildLatestJoins5() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.TIME_SERIES, " "));

    ArrayList<EntityKeyMapping> latestMappings = new ArrayList<>();
    latestMappings.add(entityKeyMapping);

    // Act
    String actualBuildLatestJoinsResult = EntityKeyMapping.buildLatestJoins(ctx, entityFilter, EntityType.TENANT,
        latestMappings, false);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals(
        "left join ts_kv_latest null ON null.entity_id=entities.id AND null.key = (select key_id from key_dictionary"
            + " where key = :null_key_id) ",
        actualBuildLatestJoinsResult);
    assertArrayEquals(new String[]{"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"})
  public void testBuildLatestJoins6() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setKeyFilters(new ArrayList<>());
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.CLIENT_ATTRIBUTE, " "));

    ArrayList<EntityKeyMapping> latestMappings = new ArrayList<>();
    latestMappings.add(entityKeyMapping);

    // Act
    String actualBuildLatestJoinsResult = EntityKeyMapping.buildLatestJoins(ctx, entityFilter, EntityType.TENANT,
        latestMappings, false);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertEquals("left join attribute_kv null ON null.entity_id=entities.id AND null.attribute_key=(select key_id from"
        + " key_dictionary where key = :null_key_id)  AND null.attribute_type=1 ", actualBuildLatestJoinsResult);
    assertArrayEquals(new String[]{"null_key_id"}, ctx.getParameterNames());
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}.
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"})
  public void testBuildLatestJoins_givenEntityKeyMapping_thenReturnEmptyString() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);

    ArrayList<EntityKeyMapping> latestMappings = new ArrayList<>();
    latestMappings.add(new EntityKeyMapping());

    // Act and Assert
    assertEquals("", EntityKeyMapping.buildLatestJoins(ctx, entityFilter, EntityType.TENANT, latestMappings, true));
    assertEquals(0, ctx.getParameterNames().length);
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}.
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"})
  public void testBuildLatestJoins_givenEntityKeyMapping_thenReturnEmptyString2() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);

    ArrayList<EntityKeyMapping> latestMappings = new ArrayList<>();
    latestMappings.add(new EntityKeyMapping());
    latestMappings.add(new EntityKeyMapping());

    // Act and Assert
    assertEquals("", EntityKeyMapping.buildLatestJoins(ctx, entityFilter, EntityType.TENANT, latestMappings, true));
    assertEquals(0, ctx.getParameterNames().length);
  }

  /**
   * Test {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildLatestJoins(QueryContext, EntityFilter, EntityType, List, boolean)"})
  public void testBuildLatestJoins_whenArrayList_thenReturnEmptyString() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));
    EntityFilter entityFilter = mock(EntityFilter.class);

    // Act and Assert
    assertEquals("", EntityKeyMapping.buildLatestJoins(ctx, entityFilter, EntityType.TENANT, new ArrayList<>(), true));
    assertEquals(0, ctx.getParameterNames().length);
  }

  /**
   * Test {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}.
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor) KeyFilters is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildQuery(QueryContext, List, EntityFilterType)"})
  public void testBuildQuery_givenEntityKeyMappingKeyFiltersIsArrayList_thenReturnEmptyString() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setKeyFilters(new ArrayList<>());

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(entityKeyMapping);

    // Act and Assert
    assertEquals("", EntityKeyMapping.buildQuery(ctx, mappings, EntityFilterType.SINGLE_ENTITY));
  }

  /**
   * Test {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}.
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildQuery(QueryContext, List, EntityFilterType)"})
  public void testBuildQuery_givenEntityKeyMapping_thenReturnEmptyString() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(new EntityKeyMapping());

    // Act and Assert
    assertEquals("", EntityKeyMapping.buildQuery(ctx, mappings, EntityFilterType.SINGLE_ENTITY));
  }

  /**
   * Test {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}.
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildQuery(QueryContext, List, EntityFilterType)"})
  public void testBuildQuery_givenEntityKeyMapping_thenReturnEmptyString2() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    ArrayList<EntityKeyMapping> mappings = new ArrayList<>();
    mappings.add(new EntityKeyMapping());
    mappings.add(new EntityKeyMapping());

    // Act and Assert
    assertEquals("", EntityKeyMapping.buildQuery(ctx, mappings, EntityFilterType.SINGLE_ENTITY));
  }

  /**
   * Test {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#buildQuery(QueryContext, List, EntityFilterType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityKeyMapping.buildQuery(QueryContext, List, EntityFilterType)"})
  public void testBuildQuery_whenArrayList_thenReturnEmptyString() {
    // Arrange
    QueryContext ctx = new QueryContext(
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, EntityType.TENANT));

    // Act and Assert
    assertEquals("", EntityKeyMapping.buildQuery(ctx, new ArrayList<>(), EntityFilterType.SINGLE_ENTITY));
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 2, "Text Search", new EntityDataSortOrder());

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter).getType();
    assertTrue(actualPrepareKeyMappingResult.isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnEmpty() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter).getType();
    assertTrue(actualPrepareKeyMappingResult.isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <ul>
   *   <li>Then return first EntityKeyColumn is {@code additional_info}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnFirstEntityKeyColumnIsAdditionalInfo() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ADDITIONAL_INFO);

    entityFields.add(entityKey);
    EntityKey entityKey2 = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    entityFields.add(entityKey2);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(0);
    assertEquals("additional_info", getResult.getEntityKeyColumn());
    EntityKeyMapping getResult2 = actualPrepareKeyMappingResult.get(1);
    assertFalse(getResult2.isLatest());
    EntityKey entityKey3 = getResult.getEntityKey();
    assertEquals(EntityKeyMapping.ADDITIONAL_INFO, entityKey3.getKey());
    assertSame(entityKey2, getResult2.getEntityKey());
    assertSame(entityKey, entityKey3);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <ul>
   *   <li>Then return first EntityKey Key is {@code alias%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnFirstEntityKeyKeyIsAliasS() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "alias%s");

    latestValues.add(entityKey);
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 2, "Text Search",
        new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key")));

    ArrayList<EntityKey> entityFields = new ArrayList<>();

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKey entityKey2 = actualPrepareKeyMappingResult.get(0).getEntityKey();
    assertEquals("alias%s", entityKey2.getKey());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(1);
    assertFalse(getResult.isSearchable());
    assertTrue(getResult.isIgnore());
    assertTrue(getResult.isSortOrder());
    assertSame(entityKey, entityKey2);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <ul>
   *   <li>Then return first hasFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnFirstHasFilter() {
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

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, new ArrayList<>(), keyFilters));

    // Assert
    verify(entityFilter).getType();
    assertEquals(1, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(0);
    assertTrue(getResult.hasFilter());
    assertEquals(keyFilters, getResult.getKeyFilters());
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <ul>
   *   <li>Then return first KeyFilters size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, new ArrayList<>(), keyFilters));

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
   * <ul>
   *   <li>Then return first Latest.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

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
   * <ul>
   *   <li>Then return not first Latest.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter).getType();
    assertEquals(1, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(0);
    EntityKey entityKey2 = getResult.getEntityKey();
    assertEquals("Key", entityKey2.getKey());
    assertFalse(getResult.isLatest());
    assertSame(entityKey, entityKey2);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <ul>
   *   <li>Then return not first Searchable.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnNotFirstSearchable() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 2, "Text Search",
        new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key")));

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter).getType();
    assertEquals(1, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(0);
    assertFalse(getResult.isSearchable());
    assertTrue(getResult.isIgnore());
    assertTrue(getResult.isSortOrder());
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <ul>
   *   <li>Then return second EntityKeyColumn is {@code additional_info}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, new ArrayList<>(), keyFilters));

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(1);
    assertEquals("additional_info", getResult.getEntityKeyColumn());
    assertFalse(getResult.isSelection());
    assertTrue(getResult.hasFilter());
    assertEquals(keyFilters, getResult.getKeyFilters());
    EntityKey entityKey = getResult.getEntityKey();
    assertEquals(EntityKeyMapping.ADDITIONAL_INFO, entityKey.getKey());
    assertSame(key, entityKey);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <ul>
   *   <li>Then return second EntityKey Key is {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnSecondEntityKeyKeyIsKey() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, EntityKeyMapping.ADDITIONAL_INFO);

    latestValues.add(entityKey);
    EntityKey entityKey2 = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    latestValues.add(entityKey2);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(1);
    EntityKey entityKey3 = getResult.getEntityKey();
    assertEquals("Key", entityKey3.getKey());
    assertTrue(getResult.isSearchable());
    EntityKey entityKey4 = actualPrepareKeyMappingResult.get(0).getEntityKey();
    assertEquals(EntityKeyMapping.ADDITIONAL_INFO, entityKey4.getKey());
    assertSame(entityKey2, entityKey3);
    assertSame(entityKey, entityKey4);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <ul>
   *   <li>Then return second EntityKey Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

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
   * <ul>
   *   <li>Then return second EntityKey Type is {@code CLIENT_ATTRIBUTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnSecondEntityKeyTypeIsClientAttribute() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    latestValues.add(new EntityKey(EntityKeyType.ATTRIBUTE, "alias%s"));
    EntityKey key = new EntityKey(EntityKeyType.CLIENT_ATTRIBUTE, "Key");

    EntityDataPageLink pageLink = new EntityDataPageLink(3, 2, "Text Search", new EntityDataSortOrder(key));

    ArrayList<EntityKey> entityFields = new ArrayList<>();

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter).getType();
    assertEquals(2, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(1);
    EntityKey entityKey = getResult.getEntityKey();
    assertEquals(EntityKeyType.CLIENT_ATTRIBUTE, entityKey.getType());
    assertTrue(getResult.isIgnore());
    assertTrue(getResult.isSortOrder());
    assertSame(key, entityKey);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <ul>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_thenReturnSizeIsThree() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    latestValues.add(new EntityKey(EntityKeyType.ATTRIBUTE, "alias%s"));
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "alias%s");

    latestValues.add(entityKey);
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    EntityDataPageLink pageLink = new EntityDataPageLink(3, 2, "Text Search", new EntityDataSortOrder(key));

    ArrayList<EntityKey> entityFields = new ArrayList<>();

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter).getType();
    assertEquals(3, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(2);
    assertEquals("alias6", getResult.getAlias());
    assertEquals("alias6_ts", getResult.getTsAlias());
    assertEquals("alias6_value", getResult.getValueAlias());
    assertEquals("alias6_value_so_num", getResult.getSortOrderNumAlias());
    assertEquals("alias6_value_so_varchar", getResult.getSortOrderStrAlias());
    assertNull(getResult.getEntityKeyColumn());
    assertNull(getResult.getKeyFilters());
    assertEquals(0, getResult.getParamIdx());
    assertEquals(6, getResult.getIndex());
    assertFalse(getResult.hasFilter());
    assertFalse(getResult.isSearchable());
    assertTrue(getResult.isIgnore());
    assertTrue(getResult.isLatest());
    assertTrue(getResult.isSelection());
    assertTrue(getResult.isSortOrder());
    assertSame(key, getResult.getEntityKey());
    assertSame(entityKey, actualPrepareKeyMappingResult.get(1).getEntityKey());
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <ul>
   *   <li>When {@link EntityFilter} {@link EntityFilter#getType()} return {@code null}.</li>
   *   <li>Then return first SortOrder.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_whenEntityFilterGetTypeReturnNull_thenReturnFirstSortOrder() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(null);

    ArrayList<EntityKey> latestValues = new ArrayList<>();
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    latestValues.add(entityKey);
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 2, "Text Search",
        new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key")));

    ArrayList<EntityKey> entityFields = new ArrayList<>();

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(EntityType.TENANT,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter).getType();
    assertEquals(1, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(0);
    EntityKey entityKey2 = getResult.getEntityKey();
    assertEquals("Key", entityKey2.getKey());
    assertTrue(getResult.isSortOrder());
    assertSame(entityKey, entityKey2);
  }

  /**
   * Test {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not first Latest.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareKeyMapping(EntityType, EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareKeyMapping(EntityType, EntityDataQuery)"})
  public void testPrepareKeyMapping_whenNull_thenReturnNotFirstLatest() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    entityFields.add(entityKey);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act
    List<EntityKeyMapping> actualPrepareKeyMappingResult = EntityKeyMapping.prepareKeyMapping(null,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter).getType();
    assertEquals(1, actualPrepareKeyMappingResult.size());
    EntityKeyMapping getResult = actualPrepareKeyMappingResult.get(0);
    EntityKey entityKey2 = getResult.getEntityKey();
    assertEquals("Key", entityKey2.getKey());
    assertFalse(getResult.isLatest());
    assertSame(entityKey, entityKey2);
  }

  /**
   * Test {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}.
   * <ul>
   *   <li>Given {@code ASSET_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareEntityCountKeyMapping(EntityCountQuery)"})
  public void testPrepareEntityCountKeyMapping_givenAssetType() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.ASSET_TYPE);

    // Act
    List<EntityKeyMapping> actualPrepareEntityCountKeyMappingResult = EntityKeyMapping
        .prepareEntityCountKeyMapping(new EntityCountQuery(entityFilter, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertTrue(actualPrepareEntityCountKeyMappingResult.isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}.
   * <ul>
   *   <li>Given {@code DEVICE_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#prepareEntityCountKeyMapping(EntityCountQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EntityKeyMapping.prepareEntityCountKeyMapping(EntityCountQuery)"})
  public void testPrepareEntityCountKeyMapping_givenDeviceType() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.DEVICE_TYPE);

    // Act
    List<EntityKeyMapping> actualPrepareEntityCountKeyMappingResult = EntityKeyMapping
        .prepareEntityCountKeyMapping(new EntityCountQuery(entityFilter, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    assertTrue(actualPrepareEntityCountKeyMappingResult.isEmpty());
  }

  /**
   * Test {@link EntityKeyMapping#getSortOrderStrAlias()}.
   * <ul>
   *   <li>Then return {@code null_so_varchar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#getSortOrderStrAlias()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then return {@code null_value_so_varchar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#getSortOrderStrAlias()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then return {@code null_so_num}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#getSortOrderNumAlias()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then return {@code null_value_so_num}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#getSortOrderNumAlias()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKeyMapping#equals(Object)}
   *   <li>{@link EntityKeyMapping#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();

    // Act and Assert
    assertEquals(entityKeyMapping, entityKeyMapping2);
    int expectedHashCodeResult = entityKeyMapping.hashCode();
    assertEquals(expectedHashCodeResult, entityKeyMapping2.hashCode());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}, and {@link EntityKeyMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKeyMapping#equals(Object)}
   *   <li>{@link EntityKeyMapping#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setAlias("Alias");

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setAlias("Alias");

    // Act and Assert
    assertEquals(entityKeyMapping, entityKeyMapping2);
    int expectedHashCodeResult = entityKeyMapping.hashCode();
    assertEquals(expectedHashCodeResult, entityKeyMapping2.hashCode());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}, and {@link EntityKeyMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKeyMapping#equals(Object)}
   *   <li>{@link EntityKeyMapping#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKeyColumn("Entity Key Column");

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKeyColumn("Entity Key Column");

    // Act and Assert
    assertEquals(entityKeyMapping, entityKeyMapping2);
    int expectedHashCodeResult = entityKeyMapping.hashCode();
    assertEquals(expectedHashCodeResult, entityKeyMapping2.hashCode());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}, and {@link EntityKeyMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKeyMapping#equals(Object)}
   *   <li>{@link EntityKeyMapping#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setKeyFilters(new ArrayList<>());

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setKeyFilters(new ArrayList<>());

    // Act and Assert
    assertEquals(entityKeyMapping, entityKeyMapping2);
    int expectedHashCodeResult = entityKeyMapping.hashCode();
    assertEquals(expectedHashCodeResult, entityKeyMapping2.hashCode());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}, and {@link EntityKeyMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKeyMapping#equals(Object)}
   *   <li>{@link EntityKeyMapping#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EntityKeyMapping entityKeyMapping = new EntityKeyMapping();
    entityKeyMapping.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    EntityKeyMapping entityKeyMapping2 = new EntityKeyMapping();
    entityKeyMapping2.setEntityKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertEquals(entityKeyMapping, entityKeyMapping2);
    int expectedHashCodeResult = entityKeyMapping.hashCode();
    assertEquals(expectedHashCodeResult, entityKeyMapping2.hashCode());
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}, and {@link EntityKeyMapping#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKeyMapping#equals(Object)}
   *   <li>{@link EntityKeyMapping#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityKeyMapping(), 1);
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityKeyMapping(), null);
  }

  /**
   * Test {@link EntityKeyMapping#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKeyMapping#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityKeyMapping.equals(Object)", "int EntityKeyMapping.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityKeyMapping(), "Different type to EntityKeyMapping");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EntityKeyMapping.<init>()", "String EntityKeyMapping.getAlias()",
      "EntityKey EntityKeyMapping.getEntityKey()", "String EntityKeyMapping.getEntityKeyColumn()",
      "int EntityKeyMapping.getIndex()", "List EntityKeyMapping.getKeyFilters()", "int EntityKeyMapping.getParamIdx()",
      "boolean EntityKeyMapping.isIgnore()", "boolean EntityKeyMapping.isLatest()",
      "boolean EntityKeyMapping.isSearchable()", "boolean EntityKeyMapping.isSelection()",
      "boolean EntityKeyMapping.isSortOrder()", "void EntityKeyMapping.setAlias(String)",
      "void EntityKeyMapping.setEntityKey(EntityKey)", "void EntityKeyMapping.setEntityKeyColumn(String)",
      "void EntityKeyMapping.setIgnore(boolean)", "void EntityKeyMapping.setIndex(int)",
      "void EntityKeyMapping.setKeyFilters(List)", "void EntityKeyMapping.setLatest(boolean)",
      "void EntityKeyMapping.setParamIdx(int)", "void EntityKeyMapping.setSearchable(boolean)",
      "void EntityKeyMapping.setSelection(boolean)", "void EntityKeyMapping.setSortOrder(boolean)",
      "String EntityKeyMapping.toString()"})
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
