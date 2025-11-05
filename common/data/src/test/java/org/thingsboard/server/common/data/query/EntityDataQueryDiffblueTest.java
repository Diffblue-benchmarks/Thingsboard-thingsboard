package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityDataQueryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is a string.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataQuery#EntityDataQuery()}
   *   <li>{@link EntityDataQuery#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDataQuery.<init>()",
    "void EntityDataQuery.<init>(EntityFilter, List)",
    "void EntityDataQuery.<init>(EntityFilter, EntityDataPageLink, List, List, List)",
    "java.lang.String EntityDataQuery.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsAString() {
    // Arrange and Act
    EntityDataQuery actualEntityDataQuery = new EntityDataQuery();

    // Assert
    assertEquals(
        "EntityDataQuery(super=AbstractDataQuery(super=EntityCountQuery(entityFilter=null, keyFilters=null),"
            + " pageLink=null, entityFields=null, latestValues=null))",
        actualEntityDataQuery.toString());
    assertNull(actualEntityDataQuery.getEntityFields());
    assertNull(actualEntityDataQuery.getLatestValues());
    assertNull(actualEntityDataQuery.getKeyFilters());
    assertNull(actualEntityDataQuery.getPageLink());
    assertNull(actualEntityDataQuery.getEntityFilter());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link EntityDataPageLink#EntityDataPageLink()}.
   *   <li>Then return EntityFields Empty.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataQuery#EntityDataQuery(EntityFilter, EntityDataPageLink, List, List,
   *       List)}
   *   <li>{@link EntityDataQuery#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when EntityDataPageLink(); then return EntityFields Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDataQuery.<init>()",
    "void EntityDataQuery.<init>(EntityFilter, List)",
    "void EntityDataQuery.<init>(EntityFilter, EntityDataPageLink, List, List, List)",
    "java.lang.String EntityDataQuery.toString()"
  })
  void testGettersAndSetters_whenEntityDataPageLink_thenReturnEntityFieldsEmpty() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act
    EntityDataQuery actualEntityDataQuery =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, keyFilters);
    actualEntityDataQuery.toString();

    // Assert
    List<EntityKey> entityFields2 = actualEntityDataQuery.getEntityFields();
    assertTrue(entityFields2.isEmpty());
    List<EntityKey> latestValues2 = actualEntityDataQuery.getLatestValues();
    assertTrue(latestValues2.isEmpty());
    List<KeyFilter> keyFilters2 = actualEntityDataQuery.getKeyFilters();
    assertTrue(keyFilters2.isEmpty());
    assertSame(entityFields, entityFields2);
    assertSame(latestValues, latestValues2);
    assertSame(keyFilters, keyFilters2);
    assertSame(pageLink, actualEntityDataQuery.getPageLink());
    assertSame(entityFilter, actualEntityDataQuery.getEntityFilter());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link EntityFilter}.
   *   <li>Then return EntityFields is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataQuery#EntityDataQuery(EntityFilter, List)}
   *   <li>{@link EntityDataQuery#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when EntityFilter; then return EntityFields is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDataQuery.<init>()",
    "void EntityDataQuery.<init>(EntityFilter, List)",
    "void EntityDataQuery.<init>(EntityFilter, EntityDataPageLink, List, List, List)",
    "java.lang.String EntityDataQuery.toString()"
  })
  void testGettersAndSetters_whenEntityFilter_thenReturnEntityFieldsIsNull() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act
    EntityDataQuery actualEntityDataQuery = new EntityDataQuery(entityFilter, keyFilters);
    actualEntityDataQuery.toString();

    // Assert
    assertNull(actualEntityDataQuery.getEntityFields());
    assertNull(actualEntityDataQuery.getLatestValues());
    assertNull(actualEntityDataQuery.getPageLink());
    List<KeyFilter> keyFilters2 = actualEntityDataQuery.getKeyFilters();
    assertTrue(keyFilters2.isEmpty());
    assertSame(keyFilters, keyFilters2);
    assertSame(entityFilter, actualEntityDataQuery.getEntityFilter());
  }

  /**
   * Test {@link EntityDataQuery#next()}.
   *
   * <ul>
   *   <li>Given {@link AlarmDataPageLink#AlarmDataPageLink()} Dynamic is {@code true}.
   *   <li>Then return PageLink Dynamic.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataQuery#next()}
   */
  @Test
  @DisplayName(
      "Test next(); given AlarmDataPageLink() Dynamic is 'true'; then return PageLink Dynamic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityDataQuery EntityDataQuery.next()"})
  void testNext_givenAlarmDataPageLinkDynamicIsTrue_thenReturnPageLinkDynamic() {
    // Arrange
    AlarmDataPageLink pageLink = new AlarmDataPageLink();
    pageLink.setDynamic(true);
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery entityDataQuery =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act and Assert
    EntityDataPageLink pageLink2 = entityDataQuery.next().getPageLink();
    assertTrue(pageLink2 instanceof AlarmDataPageLink);
    assertNull(((AlarmDataPageLink) pageLink2).getTypeList());
    assertNull(((AlarmDataPageLink) pageLink2).getStatusList());
    assertNull(((AlarmDataPageLink) pageLink2).getSeverityList());
    assertNull(((AlarmDataPageLink) pageLink2).getAssigneeId());
    assertEquals(0L, ((AlarmDataPageLink) pageLink2).getEndTs());
    assertEquals(0L, ((AlarmDataPageLink) pageLink2).getStartTs());
    assertEquals(0L, ((AlarmDataPageLink) pageLink2).getTimeWindow());
    assertFalse(((AlarmDataPageLink) pageLink2).isSearchPropagatedAlarms());
    assertTrue(pageLink2.isDynamic());
  }

  /**
   * Test {@link EntityDataQuery#next()}.
   *
   * <ul>
   *   <li>Then return not PageLink Dynamic.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataQuery#next()}
   */
  @Test
  @DisplayName("Test next(); then return not PageLink Dynamic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityDataQuery EntityDataQuery.next()"})
  void testNext_thenReturnNotPageLinkDynamic() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    AlarmDataPageLink pageLink = new AlarmDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery entityDataQuery =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act and Assert
    EntityDataPageLink pageLink2 = entityDataQuery.next().getPageLink();
    assertTrue(pageLink2 instanceof AlarmDataPageLink);
    assertNull(((AlarmDataPageLink) pageLink2).getTypeList());
    assertNull(((AlarmDataPageLink) pageLink2).getStatusList());
    assertNull(((AlarmDataPageLink) pageLink2).getSeverityList());
    assertNull(((AlarmDataPageLink) pageLink2).getAssigneeId());
    assertEquals(0L, ((AlarmDataPageLink) pageLink2).getEndTs());
    assertEquals(0L, ((AlarmDataPageLink) pageLink2).getStartTs());
    assertEquals(0L, ((AlarmDataPageLink) pageLink2).getTimeWindow());
    assertFalse(((AlarmDataPageLink) pageLink2).isSearchPropagatedAlarms());
    assertFalse(pageLink2.isDynamic());
  }

  /**
   * Test {@link EntityDataQuery#next()}.
   *
   * <ul>
   *   <li>Then return PageLink TextSearch is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataQuery#next()}
   */
  @Test
  @DisplayName("Test next(); then return PageLink TextSearch is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityDataQuery EntityDataQuery.next()"})
  void testNext_thenReturnPageLinkTextSearchIsNull() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery entityDataQuery =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    EntityDataQuery actualNextResult = entityDataQuery.next();

    // Assert
    EntityDataPageLink pageLink2 = actualNextResult.getPageLink();
    assertNull(pageLink2.getTextSearch());
    assertNull(pageLink2.getSortOrder());
    assertEquals(0, pageLink2.getPageSize());
    assertEquals(1, pageLink2.getPage());
    assertTrue(actualNextResult.getEntityFields().isEmpty());
    assertTrue(actualNextResult.getLatestValues().isEmpty());
    assertTrue(actualNextResult.getKeyFilters().isEmpty());
  }
}
