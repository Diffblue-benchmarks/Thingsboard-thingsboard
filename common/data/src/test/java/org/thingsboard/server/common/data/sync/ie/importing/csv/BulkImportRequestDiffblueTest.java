package org.thingsboard.server.common.data.sync.ie.importing.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest.ColumnMapping;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest.Mapping;

class BulkImportRequestDiffblueTest {
  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}, and {@link ColumnMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ColumnMapping#equals(Object)}
   *   <li>{@link ColumnMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ColumnMapping.equals(Object)", "int ColumnMapping.hashCode()"})
  void testColumnMappingEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ColumnMapping columnMapping = new ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(BulkImportColumnType.NAME);

    ColumnMapping columnMapping2 = new ColumnMapping();
    columnMapping2.setKey("Key");
    columnMapping2.setType(BulkImportColumnType.NAME);

    // Act and Assert
    assertEquals(columnMapping, columnMapping2);
    int expectedHashCodeResult = columnMapping.hashCode();
    assertEquals(expectedHashCodeResult, columnMapping2.hashCode());
  }

  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}, and {@link ColumnMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ColumnMapping#equals(Object)}
   *   <li>{@link ColumnMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ColumnMapping.equals(Object)", "int ColumnMapping.hashCode()"})
  void testColumnMappingEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ColumnMapping columnMapping = new ColumnMapping();
    columnMapping.setKey(null);
    columnMapping.setType(BulkImportColumnType.NAME);

    ColumnMapping columnMapping2 = new ColumnMapping();
    columnMapping2.setKey(null);
    columnMapping2.setType(BulkImportColumnType.NAME);

    // Act and Assert
    assertEquals(columnMapping, columnMapping2);
    int expectedHashCodeResult = columnMapping.hashCode();
    assertEquals(expectedHashCodeResult, columnMapping2.hashCode());
  }

  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}, and {@link ColumnMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ColumnMapping#equals(Object)}
   *   <li>{@link ColumnMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ColumnMapping.equals(Object)", "int ColumnMapping.hashCode()"})
  void testColumnMappingEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ColumnMapping columnMapping = new ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(null);

    ColumnMapping columnMapping2 = new ColumnMapping();
    columnMapping2.setKey("Key");
    columnMapping2.setType(null);

    // Act and Assert
    assertEquals(columnMapping, columnMapping2);
    int expectedHashCodeResult = columnMapping.hashCode();
    assertEquals(expectedHashCodeResult, columnMapping2.hashCode());
  }

  /**
   * Test ColumnMapping {@link ColumnMapping#equals(Object)}, and {@link ColumnMapping#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ColumnMapping#equals(Object)}
   *   <li>{@link ColumnMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ColumnMapping.equals(Object)", "int ColumnMapping.hashCode()"})
  void testColumnMappingEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ColumnMapping columnMapping = new ColumnMapping();
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
   * Method under test: {@link ColumnMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ColumnMapping.equals(Object)", "int ColumnMapping.hashCode()"})
  void testColumnMappingEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ColumnMapping columnMapping = new ColumnMapping();
    columnMapping.setKey(null);
    columnMapping.setType(BulkImportColumnType.NAME);

    ColumnMapping columnMapping2 = new ColumnMapping();
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
   * Method under test: {@link ColumnMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ColumnMapping.equals(Object)", "int ColumnMapping.hashCode()"})
  void testColumnMappingEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ColumnMapping columnMapping = new ColumnMapping();
    columnMapping.setKey("org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest$ColumnMapping");
    columnMapping.setType(BulkImportColumnType.NAME);

    ColumnMapping columnMapping2 = new ColumnMapping();
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
   * Method under test: {@link ColumnMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ColumnMapping.equals(Object)", "int ColumnMapping.hashCode()"})
  void testColumnMappingEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ColumnMapping columnMapping = new ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(null);

    ColumnMapping columnMapping2 = new ColumnMapping();
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
   * Method under test: {@link ColumnMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ColumnMapping.equals(Object)", "int ColumnMapping.hashCode()"})
  void testColumnMappingEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ColumnMapping columnMapping = new ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(BulkImportColumnType.TYPE);

    ColumnMapping columnMapping2 = new ColumnMapping();
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
   * Method under test: {@link ColumnMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ColumnMapping.equals(Object)", "int ColumnMapping.hashCode()"})
  void testColumnMappingEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ColumnMapping columnMapping = new ColumnMapping();
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
   * Method under test: {@link ColumnMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test ColumnMapping equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ColumnMapping.equals(Object)", "int ColumnMapping.hashCode()"})
  void testColumnMappingEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ColumnMapping columnMapping = new ColumnMapping();
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
   *   <li>default or parameterless constructor of {@link ColumnMapping}
   *   <li>{@link ColumnMapping#setKey(String)}
   *   <li>{@link ColumnMapping#setType(BulkImportColumnType)}
   *   <li>{@link ColumnMapping#toString()}
   *   <li>{@link ColumnMapping#getKey()}
   *   <li>{@link ColumnMapping#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test ColumnMapping getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ColumnMapping.<init>()", "String ColumnMapping.getKey()",
      "BulkImportColumnType ColumnMapping.getType()", "void ColumnMapping.setKey(String)",
      "void ColumnMapping.setType(BulkImportColumnType)", "String ColumnMapping.toString()"})
  void testColumnMappingGettersAndSetters() {
    // Arrange and Act
    ColumnMapping actualColumnMapping = new ColumnMapping();
    actualColumnMapping.setKey("Key");
    actualColumnMapping.setType(BulkImportColumnType.NAME);
    String actualToStringResult = actualColumnMapping.toString();
    String actualKey = actualColumnMapping.getKey();

    // Assert
    assertEquals("BulkImportRequest.ColumnMapping(type=NAME, key=Key)", actualToStringResult);
    assertEquals("Key", actualKey);
    assertEquals(BulkImportColumnType.NAME, actualColumnMapping.getType());
  }

  /**
   * Test {@link BulkImportRequest#equals(Object)}, and {@link BulkImportRequest#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BulkImportRequest.equals(Object)", "int BulkImportRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest bulkImportRequest = new BulkImportRequest();
    bulkImportRequest.setFile("File");
    bulkImportRequest.setMapping(mapping);

    Mapping mapping2 = new Mapping();
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
   * Test {@link BulkImportRequest#equals(Object)}, and {@link BulkImportRequest#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BulkImportRequest.equals(Object)", "int BulkImportRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Mapping mapping = new Mapping();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BulkImportRequest.equals(Object)", "int BulkImportRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest bulkImportRequest = new BulkImportRequest();
    bulkImportRequest.setFile(null);
    bulkImportRequest.setMapping(mapping);

    Mapping mapping2 = new Mapping();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BulkImportRequest.equals(Object)", "int BulkImportRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest bulkImportRequest = new BulkImportRequest();
    bulkImportRequest.setFile("org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest");
    bulkImportRequest.setMapping(mapping);

    Mapping mapping2 = new Mapping();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BulkImportRequest.equals(Object)", "int BulkImportRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Mapping mapping = mock(Mapping.class);
    doNothing().when(mapping).setColumns(Mockito.<List<ColumnMapping>>any());
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

    Mapping mapping2 = new Mapping();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BulkImportRequest.equals(Object)", "int BulkImportRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Mapping mapping = new Mapping();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BulkImportRequest.equals(Object)", "int BulkImportRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Mapping mapping = new Mapping();
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
   *   <li>{@link BulkImportRequest#setMapping(Mapping)}
   *   <li>{@link BulkImportRequest#toString()}
   *   <li>{@link BulkImportRequest#getFile()}
   *   <li>{@link BulkImportRequest#getMapping()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BulkImportRequest.<init>()", "String BulkImportRequest.getFile()",
      "Mapping BulkImportRequest.getMapping()", "void BulkImportRequest.setFile(String)",
      "void BulkImportRequest.setMapping(Mapping)", "String BulkImportRequest.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    BulkImportRequest actualBulkImportRequest = new BulkImportRequest();
    actualBulkImportRequest.setFile("File");
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);
    actualBulkImportRequest.setMapping(mapping);
    String actualToStringResult = actualBulkImportRequest.toString();
    String actualFile = actualBulkImportRequest.getFile();

    // Assert
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
   *   <li>{@link Mapping#equals(Object)}
   *   <li>{@link Mapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Mapping equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    Mapping mapping2 = new Mapping();
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
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Mapping#equals(Object)}
   *   <li>{@link Mapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Mapping equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter(null);
    mapping.setHeader(true);
    mapping.setUpdate(true);

    Mapping mapping2 = new Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter(null);
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
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Mapping#equals(Object)}
   *   <li>{@link Mapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Mapping equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(null);
    mapping.setUpdate(true);

    Mapping mapping2 = new Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(null);
    mapping2.setUpdate(true);

    // Act and Assert
    assertEquals(mapping, mapping2);
    int expectedHashCodeResult = mapping.hashCode();
    assertEquals(expectedHashCodeResult, mapping2.hashCode());
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
   *   <li>{@link Mapping#equals(Object)}
   *   <li>{@link Mapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Mapping equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(null);

    Mapping mapping2 = new Mapping();
    mapping2.setColumns(new ArrayList<>());
    mapping2.setDelimiter('A');
    mapping2.setHeader(true);
    mapping2.setUpdate(null);

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
   *   <li>{@link Mapping#equals(Object)}
   *   <li>{@link Mapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Mapping equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Mapping mapping = new Mapping();
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
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ColumnMapping columnMapping = new ColumnMapping();
    columnMapping.setKey("Key");
    columnMapping.setType(BulkImportColumnType.NAME);

    ArrayList<ColumnMapping> columns = new ArrayList<>();
    columns.add(columnMapping);

    Mapping mapping = new Mapping();
    mapping.setColumns(columns);
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    Mapping mapping2 = new Mapping();
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
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('\u0001');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    Mapping mapping2 = new Mapping();
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
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter(null);
    mapping.setHeader(true);
    mapping.setUpdate(true);

    Mapping mapping2 = new Mapping();
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
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(false);
    mapping.setUpdate(true);

    Mapping mapping2 = new Mapping();
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
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(null);
    mapping.setUpdate(true);

    Mapping mapping2 = new Mapping();
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
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(false);

    Mapping mapping2 = new Mapping();
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
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(null);

    Mapping mapping2 = new Mapping();
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
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Mapping mapping = new Mapping();
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
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test Mapping equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testMappingEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Mapping mapping = new Mapping();
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
   *   <li>default or parameterless constructor of {@link Mapping}
   *   <li>{@link Mapping#setColumns(List)}
   *   <li>{@link Mapping#setDelimiter(Character)}
   *   <li>{@link Mapping#setHeader(Boolean)}
   *   <li>{@link Mapping#setUpdate(Boolean)}
   *   <li>{@link Mapping#toString()}
   *   <li>{@link Mapping#getColumns()}
   *   <li>{@link Mapping#getDelimiter()}
   *   <li>{@link Mapping#getHeader()}
   *   <li>{@link Mapping#getUpdate()}
   * </ul>
   */
  @Test
  @DisplayName("Test Mapping getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Mapping.<init>()", "List Mapping.getColumns()", "Character Mapping.getDelimiter()",
      "Boolean Mapping.getHeader()", "Boolean Mapping.getUpdate()", "void Mapping.setColumns(List)",
      "void Mapping.setDelimiter(Character)", "void Mapping.setHeader(Boolean)", "void Mapping.setUpdate(Boolean)",
      "String Mapping.toString()"})
  void testMappingGettersAndSetters() {
    // Arrange and Act
    Mapping actualMapping = new Mapping();
    ArrayList<ColumnMapping> columns = new ArrayList<>();
    actualMapping.setColumns(columns);
    actualMapping.setDelimiter('A');
    actualMapping.setHeader(true);
    actualMapping.setUpdate(true);
    String actualToStringResult = actualMapping.toString();
    List<ColumnMapping> actualColumns = actualMapping.getColumns();
    Character actualDelimiter = actualMapping.getDelimiter();
    Boolean actualHeader = actualMapping.getHeader();
    Boolean actualUpdate = actualMapping.getUpdate();

    // Assert
    assertEquals("BulkImportRequest.Mapping(columns=[], delimiter=A, update=true, header=true)", actualToStringResult);
    assertEquals('A', actualDelimiter.charValue());
    assertTrue(actualColumns.isEmpty());
    assertTrue(actualHeader);
    assertTrue(actualUpdate);
    assertSame(columns, actualColumns);
  }
}
