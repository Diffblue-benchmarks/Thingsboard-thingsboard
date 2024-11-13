package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.EntityData;
import org.thingsboard.server.common.data.query.EntityDataPageLink;
import org.thingsboard.server.common.data.query.EntityDataSortOrder;

public class EntityDataAdapterDiffblueTest {
  /**
   * Test
   * {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}.
   * <p>
   * Method under test:
   * {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}
   */
  @Test
  public void testCreateEntityData() {
    // Arrange
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder());

    ArrayList<EntityKeyMapping> selectionMapping = new ArrayList<>();

    // Act
    PageData<EntityData> actualCreateEntityDataResult = EntityDataAdapter.createEntityData(pageLink, selectionMapping,
        new ArrayList<>(), 1);

    // Assert
    assertEquals(1, actualCreateEntityDataResult.getTotalPages());
    assertEquals(1L, actualCreateEntityDataResult.getTotalElements());
    assertFalse(actualCreateEntityDataResult.hasNext());
    assertTrue(actualCreateEntityDataResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}.
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link EntityKeyMapping} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}
   */
  @Test
  public void testCreateEntityData_givenEntityKeyMapping_whenArrayListAddEntityKeyMapping() {
    // Arrange
    EntityDataPageLink pageLink = new EntityDataPageLink();

    ArrayList<EntityKeyMapping> selectionMapping = new ArrayList<>();
    selectionMapping.add(new EntityKeyMapping());

    // Act
    PageData<EntityData> actualCreateEntityDataResult = EntityDataAdapter.createEntityData(pageLink, selectionMapping,
        new ArrayList<>(), 1);

    // Assert
    assertEquals(1, actualCreateEntityDataResult.getTotalPages());
    assertEquals(1L, actualCreateEntityDataResult.getTotalElements());
    assertFalse(actualCreateEntityDataResult.hasNext());
    assertTrue(actualCreateEntityDataResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}.
   * <ul>
   *   <li>Given {@link EntityKeyMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link EntityKeyMapping} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}
   */
  @Test
  public void testCreateEntityData_givenEntityKeyMapping_whenArrayListAddEntityKeyMapping2() {
    // Arrange
    EntityDataPageLink pageLink = new EntityDataPageLink();

    ArrayList<EntityKeyMapping> selectionMapping = new ArrayList<>();
    selectionMapping.add(new EntityKeyMapping());
    selectionMapping.add(new EntityKeyMapping());

    // Act
    PageData<EntityData> actualCreateEntityDataResult = EntityDataAdapter.createEntityData(pageLink, selectionMapping,
        new ArrayList<>(), 1);

    // Assert
    assertEquals(1, actualCreateEntityDataResult.getTotalPages());
    assertEquals(1L, actualCreateEntityDataResult.getTotalElements());
    assertFalse(actualCreateEntityDataResult.hasNext());
    assertTrue(actualCreateEntityDataResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then return hasNext.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}
   */
  @Test
  public void testCreateEntityData_givenThree_thenReturnHasNext() {
    // Arrange
    EntityDataPageLink pageLink = new EntityDataPageLink();
    pageLink.setPageSize(3);
    ArrayList<EntityKeyMapping> selectionMapping = new ArrayList<>();

    // Act
    PageData<EntityData> actualCreateEntityDataResult = EntityDataAdapter.createEntityData(pageLink, selectionMapping,
        new ArrayList<>(), 1);

    // Assert
    assertEquals(1, actualCreateEntityDataResult.getTotalPages());
    assertEquals(1L, actualCreateEntityDataResult.getTotalElements());
    assertTrue(actualCreateEntityDataResult.getData().isEmpty());
    assertTrue(actualCreateEntityDataResult.hasNext());
  }

  /**
   * Test
   * {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}.
   * <ul>
   *   <li>When {@link EntityDataPageLink#EntityDataPageLink()}.</li>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}
   */
  @Test
  public void testCreateEntityData_whenEntityDataPageLink_thenReturnNotHasNext() {
    // Arrange
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKeyMapping> selectionMapping = new ArrayList<>();

    // Act
    PageData<EntityData> actualCreateEntityDataResult = EntityDataAdapter.createEntityData(pageLink, selectionMapping,
        new ArrayList<>(), 1);

    // Assert
    assertEquals(1, actualCreateEntityDataResult.getTotalPages());
    assertEquals(1L, actualCreateEntityDataResult.getTotalElements());
    assertFalse(actualCreateEntityDataResult.hasNext());
    assertTrue(actualCreateEntityDataResult.getData().isEmpty());
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  public void testConvertValue_whenDot_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", EntityDataAdapter.convertValue("."));
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  public void testConvertValue_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", EntityDataAdapter.convertValue(""));
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  public void testConvertValue_whenFortyTwo_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EntityDataAdapter.convertValue(42));
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  public void testConvertValue_whenMinusOne_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("-1", EntityDataAdapter.convertValue(-1));
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  public void testConvertValue_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", EntityDataAdapter.convertValue(null));
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  public void testConvertValue_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("Value", EntityDataAdapter.convertValue("Value"));
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  public void testConvertValue_whenZero_thenReturn0() {
    // Arrange, Act and Assert
    assertEquals("0", EntityDataAdapter.convertValue(0));
  }
}
