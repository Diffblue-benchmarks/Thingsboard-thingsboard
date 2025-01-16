package org.thingsboard.server.common.data.sync.ie.importing.csv;

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
import org.mockito.Mockito;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest.ColumnMapping;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest.Mapping;

class BulkImportRequestDiffblueTest {
  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}, and
   * {@link ColumnMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BulkImportRequest.ColumnMapping#equals(Object)}
   *   <li>{@link BulkImportRequest.ColumnMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object), and hashCode(); when other is equal; then return equal")
  void testColumnMappingEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BulkImportRequest.ColumnMapping columnMapping = new BulkImportRequest.ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(BulkImportColumnType.NAME);

    BulkImportRequest.ColumnMapping columnMapping2 = new BulkImportRequest.ColumnMapping();
    columnMapping2.setKey("Key");
    columnMapping2.setType(BulkImportColumnType.NAME);

    // Act and Assert
    assertEquals(columnMapping, columnMapping2);
    int expectedHashCodeResult = columnMapping.hashCode();
    assertEquals(expectedHashCodeResult, columnMapping2.hashCode());
  }

  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}, and
   * {@link ColumnMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BulkImportRequest.ColumnMapping#equals(Object)}
   *   <li>{@link BulkImportRequest.ColumnMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object), and hashCode(); when other is equal; then return equal")
  void testColumnMappingEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BulkImportRequest.ColumnMapping columnMapping = new BulkImportRequest.ColumnMapping();
    columnMapping.setKey(null);
    columnMapping.setType(BulkImportColumnType.NAME);

    BulkImportRequest.ColumnMapping columnMapping2 = new BulkImportRequest.ColumnMapping();
    columnMapping2.setKey(null);
    columnMapping2.setType(BulkImportColumnType.NAME);

    // Act and Assert
    assertEquals(columnMapping, columnMapping2);
    int expectedHashCodeResult = columnMapping.hashCode();
    assertEquals(expectedHashCodeResult, columnMapping2.hashCode());
  }

  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}, and
   * {@link ColumnMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BulkImportRequest.ColumnMapping#equals(Object)}
   *   <li>{@link BulkImportRequest.ColumnMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object), and hashCode(); when other is equal; then return equal")
  void testColumnMappingEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BulkImportRequest.ColumnMapping columnMapping = new BulkImportRequest.ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(null);

    BulkImportRequest.ColumnMapping columnMapping2 = new BulkImportRequest.ColumnMapping();
    columnMapping2.setKey("Key");
    columnMapping2.setType(null);

    // Act and Assert
    assertEquals(columnMapping, columnMapping2);
    int expectedHashCodeResult = columnMapping.hashCode();
    assertEquals(expectedHashCodeResult, columnMapping2.hashCode());
  }

  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}, and
   * {@link ColumnMapping#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BulkImportRequest.ColumnMapping#equals(Object)}
   *   <li>{@link BulkImportRequest.ColumnMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object), and hashCode(); when other is same; then return equal")
  void testColumnMappingEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BulkImportRequest.ColumnMapping columnMapping = new BulkImportRequest.ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(BulkImportColumnType.NAME);

    // Act and Assert
    assertEquals(columnMapping, columnMapping);
    int expectedHashCodeResult = columnMapping.hashCode();
    assertEquals(expectedHashCodeResult, columnMapping.hashCode());
  }

  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.ColumnMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object); when other is different; then return not equal")
  void testColumnMappingEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BulkImportRequest.ColumnMapping columnMapping = new BulkImportRequest.ColumnMapping();
    columnMapping.setKey(null);
    columnMapping.setType(BulkImportColumnType.NAME);

    BulkImportRequest.ColumnMapping columnMapping2 = new BulkImportRequest.ColumnMapping();
    columnMapping2.setKey("Key");
    columnMapping2.setType(BulkImportColumnType.NAME);

    // Act and Assert
    assertNotEquals(columnMapping, columnMapping2);
  }

  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.ColumnMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object); when other is different; then return not equal")
  void testColumnMappingEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BulkImportRequest.ColumnMapping columnMapping = new BulkImportRequest.ColumnMapping();
    columnMapping.setKey("org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest$ColumnMapping");
    columnMapping.setType(BulkImportColumnType.NAME);

    BulkImportRequest.ColumnMapping columnMapping2 = new BulkImportRequest.ColumnMapping();
    columnMapping2.setKey("Key");
    columnMapping2.setType(BulkImportColumnType.NAME);

    // Act and Assert
    assertNotEquals(columnMapping, columnMapping2);
  }

  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.ColumnMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object); when other is different; then return not equal")
  void testColumnMappingEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BulkImportRequest.ColumnMapping columnMapping = new BulkImportRequest.ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(null);

    BulkImportRequest.ColumnMapping columnMapping2 = new BulkImportRequest.ColumnMapping();
    columnMapping2.setKey("Key");
    columnMapping2.setType(BulkImportColumnType.NAME);

    // Act and Assert
    assertNotEquals(columnMapping, columnMapping2);
  }

  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.ColumnMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object); when other is different; then return not equal")
  void testColumnMappingEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BulkImportRequest.ColumnMapping columnMapping = new BulkImportRequest.ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(BulkImportColumnType.TYPE);

    BulkImportRequest.ColumnMapping columnMapping2 = new BulkImportRequest.ColumnMapping();
    columnMapping2.setKey("Key");
    columnMapping2.setType(BulkImportColumnType.NAME);

    // Act and Assert
    assertNotEquals(columnMapping, columnMapping2);
  }

  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.ColumnMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object); when other is 'null'; then return not equal")
  void testColumnMappingEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BulkImportRequest.ColumnMapping columnMapping = new BulkImportRequest.ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(BulkImportColumnType.NAME);

    // Act and Assert
    assertNotEquals(columnMapping, null);
  }

  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.ColumnMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object); when other is wrong type; then return not equal")
  void testColumnMappingEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BulkImportRequest.ColumnMapping columnMapping = new BulkImportRequest.ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(BulkImportColumnType.NAME);

    // Act and Assert
    assertNotEquals(columnMapping, "Different type to ColumnMapping");
  }

  /**
   * Test ColumnMapping getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BulkImportRequest.ColumnMapping}
   *   <li>{@link BulkImportRequest.ColumnMapping#setKey(String)}
   *   <li>{@link BulkImportRequest.ColumnMapping#setType(BulkImportColumnType)}
   *   <li>{@link BulkImportRequest.ColumnMapping#toString()}
   *   <li>{@link BulkImportRequest.ColumnMapping#getKey()}
   *   <li>{@link BulkImportRequest.ColumnMapping#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test ColumnMapping getters and setters")
  void testColumnMappingGettersAndSetters() {
    // Arrange and Act
    BulkImportRequest.ColumnMapping actualColumnMapping = new BulkImportRequest.ColumnMapping();
    actualColumnMapping.setKey("Key");
    actualColumnMapping.setType(BulkImportColumnType.NAME);
    String actualToStringResult = actualColumnMapping.toString();
    String actualKey = actualColumnMapping.getKey();

    // Assert that nothing has changed
    assertEquals("BulkImportRequest.ColumnMapping(type=NAME, key=Key)", actualToStringResult);
    assertEquals("Key", actualKey);
    assertEquals(BulkImportColumnType.NAME, actualColumnMapping.getType());
  }

  /**
   * Test {@link BulkImportRequest#equals(Object)}, and
   * {@link BulkImportRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BulkImportRequest#equals(Object)}
   *   <li>{@link BulkImportRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest bulkImportRequest = new BulkImportRequest();
    bulkImportRequest.setFile("File");
    bulkImportRequest.setMapping(mapping);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    BulkImportRequest bulkImportRequest2 = new BulkImportRequest();
    bulkImportRequest2.setFile("File");
    bulkImportRequest2.setMapping(mapping2);

    // Act and Assert
    assertEquals(bulkImportRequest, bulkImportRequest2);
    int expectedHashCodeResult = bulkImportRequest.hashCode();
    assertEquals(expectedHashCodeResult, bulkImportRequest2.hashCode());
  }

  /**
   * Test {@link BulkImportRequest#equals(Object)}, and
   * {@link BulkImportRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BulkImportRequest#equals(Object)}
   *   <li>{@link BulkImportRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest bulkImportRequest = new BulkImportRequest();
    bulkImportRequest.setFile("File");
    bulkImportRequest.setMapping(mapping);

    // Act and Assert
    assertEquals(bulkImportRequest, bulkImportRequest);
    int expectedHashCodeResult = bulkImportRequest.hashCode();
    assertEquals(expectedHashCodeResult, bulkImportRequest.hashCode());
  }

  /**
   * Test {@link BulkImportRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest bulkImportRequest = new BulkImportRequest();
    bulkImportRequest.setFile(null);
    bulkImportRequest.setMapping(mapping);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    BulkImportRequest bulkImportRequest2 = new BulkImportRequest();
    bulkImportRequest2.setFile("File");
    bulkImportRequest2.setMapping(mapping2);

    // Act and Assert
    assertNotEquals(bulkImportRequest, bulkImportRequest2);
  }

  /**
   * Test {@link BulkImportRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest bulkImportRequest = new BulkImportRequest();
    bulkImportRequest.setFile("org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest");
    bulkImportRequest.setMapping(mapping);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    BulkImportRequest bulkImportRequest2 = new BulkImportRequest();
    bulkImportRequest2.setFile("File");
    bulkImportRequest2.setMapping(mapping2);

    // Act and Assert
    assertNotEquals(bulkImportRequest, bulkImportRequest2);
  }

  /**
   * Test {@link BulkImportRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BulkImportRequest.Mapping mapping = mock(BulkImportRequest.Mapping.class);
    doNothing().when(mapping).setColumns(Mockito.<List<BulkImportRequest.ColumnMapping>>any());
    doNothing().when(mapping).setDelimiter(Mockito.<Character>any());
    doNothing().when(mapping).setHeader(Mockito.<Boolean>any());
    doNothing().when(mapping).setUpdate(Mockito.<Boolean>any());
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest bulkImportRequest = new BulkImportRequest();
    bulkImportRequest.setFile("File");
    bulkImportRequest.setMapping(mapping);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    BulkImportRequest bulkImportRequest2 = new BulkImportRequest();
    bulkImportRequest2.setFile("File");
    bulkImportRequest2.setMapping(mapping2);

    // Act and Assert
    assertNotEquals(bulkImportRequest, bulkImportRequest2);
  }

  /**
   * Test {@link BulkImportRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest bulkImportRequest = new BulkImportRequest();
    bulkImportRequest.setFile("File");
    bulkImportRequest.setMapping(mapping);

    // Act and Assert
    assertNotEquals(bulkImportRequest, null);
  }

  /**
   * Test {@link BulkImportRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest bulkImportRequest = new BulkImportRequest();
    bulkImportRequest.setFile("File");
    bulkImportRequest.setMapping(mapping);

    // Act and Assert
    assertNotEquals(bulkImportRequest, "Different type to BulkImportRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BulkImportRequest}
   *   <li>{@link BulkImportRequest#setFile(String)}
   *   <li>{@link BulkImportRequest#setMapping(BulkImportRequest.Mapping)}
   *   <li>{@link BulkImportRequest#toString()}
   *   <li>{@link BulkImportRequest#getFile()}
   *   <li>{@link BulkImportRequest#getMapping()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BulkImportRequest actualBulkImportRequest = new BulkImportRequest();
    actualBulkImportRequest.setFile("File");
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);
    actualBulkImportRequest.setMapping(mapping);
    String actualToStringResult = actualBulkImportRequest.toString();
    String actualFile = actualBulkImportRequest.getFile();

    // Assert that nothing has changed
    assertEquals("BulkImportRequest(file=File, mapping=BulkImportRequest.Mapping(columns=[], delimiter=A, update=true,"
        + " header=true))", actualToStringResult);
    assertEquals("File", actualFile);
    assertSame(mapping, actualBulkImportRequest.getMapping());
  }

  /**
   * Test Mapping {@link Mapping#equals(Object)}, and {@link Mapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BulkImportRequest.Mapping#equals(Object)}
   *   <li>{@link BulkImportRequest.Mapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Mapping equals(Object), and hashCode(); when other is equal; then return equal")
  void testMappingEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    // Act and Assert
    assertEquals(mapping, mapping2);
    int expectedHashCodeResult = mapping.hashCode();
    assertEquals(expectedHashCodeResult, mapping2.hashCode());
  }

  /**
   * Test Mapping {@link Mapping#equals(Object)}, and {@link Mapping#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BulkImportRequest.Mapping#equals(Object)}
   *   <li>{@link BulkImportRequest.Mapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Mapping equals(Object), and hashCode(); when other is same; then return equal")
  void testMappingEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    // Act and Assert
    assertEquals(mapping, mapping);
    int expectedHashCodeResult = mapping.hashCode();
    assertEquals(expectedHashCodeResult, mapping.hashCode());
  }

  /**
   * Test Mapping {@link Mapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BulkImportRequest.ColumnMapping columnMapping = new BulkImportRequest.ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(BulkImportColumnType.NAME);

    ArrayList<BulkImportRequest.ColumnMapping> columns = new ArrayList<>();
    columns.add(columnMapping);

    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(columns);
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    // Act and Assert
    assertNotEquals(mapping, mapping2);
  }

  /**
   * Test Mapping {@link Mapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('\u0001');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    // Act and Assert
    assertNotEquals(mapping, mapping2);
  }

  /**
   * Test Mapping {@link Mapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter(null);
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    // Act and Assert
    assertNotEquals(mapping, mapping2);
  }

  /**
   * Test Mapping {@link Mapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(false);
    mapping.setUpdate(true);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    // Act and Assert
    assertNotEquals(mapping, mapping2);
  }

  /**
   * Test Mapping {@link Mapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(null);
    mapping.setUpdate(true);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    // Act and Assert
    assertNotEquals(mapping, mapping2);
  }

  /**
   * Test Mapping {@link Mapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(false);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    // Act and Assert
    assertNotEquals(mapping, mapping2);
  }

  /**
   * Test Mapping {@link Mapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(null);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    // Act and Assert
    assertNotEquals(mapping, mapping2);
  }

  /**
   * Test Mapping {@link Mapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    BulkImportRequest.ColumnMapping columnMapping = mock(BulkImportRequest.ColumnMapping.class);
    doNothing().when(columnMapping).setKey(Mockito.<String>any());
    doNothing().when(columnMapping).setType(Mockito.<BulkImportColumnType>any());
    columnMapping.setKey("Key");
    columnMapping.setType(BulkImportColumnType.NAME);

    ArrayList<BulkImportRequest.ColumnMapping> columns = new ArrayList<>();
    columns.add(columnMapping);

    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(columns);
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest.Mapping mapping2 = new BulkImportRequest.Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(true);

    // Act and Assert
    assertNotEquals(mapping, mapping2);
  }

  /**
   * Test Mapping {@link Mapping#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is 'null'; then return not equal")
  void testMappingEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    // Act and Assert
    assertNotEquals(mapping, null);
  }

  /**
   * Test Mapping {@link Mapping#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportRequest.Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is wrong type; then return not equal")
  void testMappingEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BulkImportRequest.Mapping mapping = new BulkImportRequest.Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    // Act and Assert
    assertNotEquals(mapping, "Different type to Mapping");
  }

  /**
   * Test Mapping getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BulkImportRequest.Mapping}
   *   <li>{@link BulkImportRequest.Mapping#setColumns(List)}
   *   <li>{@link BulkImportRequest.Mapping#setDelimiter(Character)}
   *   <li>{@link BulkImportRequest.Mapping#setHeader(Boolean)}
   *   <li>{@link BulkImportRequest.Mapping#setUpdate(Boolean)}
   *   <li>{@link BulkImportRequest.Mapping#toString()}
   *   <li>{@link BulkImportRequest.Mapping#getColumns()}
   *   <li>{@link BulkImportRequest.Mapping#getDelimiter()}
   *   <li>{@link BulkImportRequest.Mapping#getHeader()}
   *   <li>{@link BulkImportRequest.Mapping#getUpdate()}
   * </ul>
   */
  @Test
  @DisplayName("Test Mapping getters and setters")
  void testMappingGettersAndSetters() {
    // Arrange and Act
    BulkImportRequest.Mapping actualMapping = new BulkImportRequest.Mapping();
    ArrayList<BulkImportRequest.ColumnMapping> columns = new ArrayList<>();
    actualMapping.setColumns(columns);
    actualMapping.setDelimiter('A');
    actualMapping.setHeader(true);
    actualMapping.setUpdate(true);
    String actualToStringResult = actualMapping.toString();
    List<BulkImportRequest.ColumnMapping> actualColumns = actualMapping.getColumns();
    Character actualDelimiter = actualMapping.getDelimiter();
    Boolean actualHeader = actualMapping.getHeader();
    Boolean actualUpdate = actualMapping.getUpdate();

    // Assert that nothing has changed
    assertEquals("BulkImportRequest.Mapping(columns=[], delimiter=A, update=true, header=true)", actualToStringResult);
    assertEquals('A', actualDelimiter.charValue());
    assertTrue(actualColumns.isEmpty());
    assertTrue(actualHeader);
    assertTrue(actualUpdate);
    assertSame(columns, actualColumns);
  }
}
