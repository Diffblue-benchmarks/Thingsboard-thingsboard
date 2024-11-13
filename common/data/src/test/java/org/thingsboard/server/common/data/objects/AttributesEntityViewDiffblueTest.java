package org.thingsboard.server.common.data.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttributesEntityViewDiffblueTest {
  /**
   * Test {@link AttributesEntityView#equals(Object)}, and
   * {@link AttributesEntityView#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributesEntityView#equals(Object)}
   *   <li>{@link AttributesEntityView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributesEntityView attributesEntityView = new AttributesEntityView();
    AttributesEntityView attributesEntityView2 = new AttributesEntityView();

    // Act and Assert
    assertEquals(attributesEntityView, attributesEntityView2);
    int expectedHashCodeResult = attributesEntityView.hashCode();
    assertEquals(expectedHashCodeResult, attributesEntityView2.hashCode());
  }

  /**
   * Test {@link AttributesEntityView#equals(Object)}, and
   * {@link AttributesEntityView#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributesEntityView#equals(Object)}
   *   <li>{@link AttributesEntityView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributesEntityView attributesEntityView = new AttributesEntityView();

    // Act and Assert
    assertEquals(attributesEntityView, attributesEntityView);
    int expectedHashCodeResult = attributesEntityView.hashCode();
    assertEquals(expectedHashCodeResult, attributesEntityView.hashCode());
  }

  /**
   * Test {@link AttributesEntityView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesEntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributesEntityView(), 1);
  }

  /**
   * Test {@link AttributesEntityView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesEntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<String> cs = new ArrayList<>();
    cs.add("foo");
    ArrayList<String> ss = new ArrayList<>();
    AttributesEntityView attributesEntityView = new AttributesEntityView(cs, ss, new ArrayList<>());

    // Act and Assert
    assertNotEquals(attributesEntityView, new AttributesEntityView());
  }

  /**
   * Test {@link AttributesEntityView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesEntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<String> ss = new ArrayList<>();
    ss.add("foo");
    ArrayList<String> cs = new ArrayList<>();
    AttributesEntityView attributesEntityView = new AttributesEntityView(cs, ss, new ArrayList<>());

    // Act and Assert
    assertNotEquals(attributesEntityView, new AttributesEntityView());
  }

  /**
   * Test {@link AttributesEntityView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesEntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<String> sh = new ArrayList<>();
    sh.add("foo");
    ArrayList<String> cs = new ArrayList<>();
    AttributesEntityView attributesEntityView = new AttributesEntityView(cs, new ArrayList<>(), sh);

    // Act and Assert
    assertNotEquals(attributesEntityView, new AttributesEntityView());
  }

  /**
   * Test {@link AttributesEntityView#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesEntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributesEntityView(), null);
  }

  /**
   * Test {@link AttributesEntityView#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesEntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributesEntityView(), "Different type to AttributesEntityView");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributesEntityView#AttributesEntityView()}
   *   <li>{@link AttributesEntityView#setCs(List)}
   *   <li>{@link AttributesEntityView#setSh(List)}
   *   <li>{@link AttributesEntityView#setSs(List)}
   *   <li>{@link AttributesEntityView#toString()}
   *   <li>{@link AttributesEntityView#getCs()}
   *   <li>{@link AttributesEntityView#getSh()}
   *   <li>{@link AttributesEntityView#getSs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AttributesEntityView actualAttributesEntityView = new AttributesEntityView();
    ArrayList<String> cs = new ArrayList<>();
    actualAttributesEntityView.setCs(cs);
    ArrayList<String> sh = new ArrayList<>();
    actualAttributesEntityView.setSh(sh);
    ArrayList<String> ss = new ArrayList<>();
    actualAttributesEntityView.setSs(ss);
    String actualToStringResult = actualAttributesEntityView.toString();
    List<String> actualCs = actualAttributesEntityView.getCs();
    List<String> actualSh = actualAttributesEntityView.getSh();
    List<String> actualSs = actualAttributesEntityView.getSs();

    // Assert that nothing has changed
    assertEquals("AttributesEntityView(cs=[], ss=[], sh=[])", actualToStringResult);
    assertTrue(actualCs.isEmpty());
    assertTrue(actualSh.isEmpty());
    assertTrue(actualSs.isEmpty());
    assertSame(cs, actualCs);
    assertSame(sh, actualSh);
    assertSame(ss, actualSs);
  }

  /**
   * Test {@link AttributesEntityView#AttributesEntityView(AttributesEntityView)}.
   * <p>
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(AttributesEntityView)}
   */
  @Test
  @DisplayName("Test new AttributesEntityView(AttributesEntityView)")
  void testNewAttributesEntityView() {
    // Arrange
    AttributesEntityView obj = new AttributesEntityView();

    // Act and Assert
    assertEquals(obj, new AttributesEntityView(obj));
  }

  /**
   * Test {@link AttributesEntityView#AttributesEntityView(List, List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Cs is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  @DisplayName("Test new AttributesEntityView(List, List, List); given '42'; when ArrayList() add '42'; then return Cs is ArrayList()")
  void testNewAttributesEntityView_given42_whenArrayListAdd42_thenReturnCsIsArrayList() {
    // Arrange
    ArrayList<String> cs = new ArrayList<>();
    cs.add("42");
    cs.add("foo");
    ArrayList<String> ss = new ArrayList<>();

    // Act
    AttributesEntityView actualAttributesEntityView = new AttributesEntityView(cs, ss, new ArrayList<>());

    // Assert
    assertTrue(actualAttributesEntityView.getSh().isEmpty());
    assertTrue(actualAttributesEntityView.getSs().isEmpty());
    assertEquals(cs, actualAttributesEntityView.getCs());
  }

  /**
   * Test {@link AttributesEntityView#AttributesEntityView(List, List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Sh is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  @DisplayName("Test new AttributesEntityView(List, List, List); given '42'; when ArrayList() add '42'; then return Sh is ArrayList()")
  void testNewAttributesEntityView_given42_whenArrayListAdd42_thenReturnShIsArrayList() {
    // Arrange
    ArrayList<String> cs = new ArrayList<>();
    ArrayList<String> ss = new ArrayList<>();

    ArrayList<String> sh = new ArrayList<>();
    sh.add("42");
    sh.add("foo");

    // Act and Assert
    assertEquals(sh, (new AttributesEntityView(cs, ss, sh)).getSh());
  }

  /**
   * Test {@link AttributesEntityView#AttributesEntityView(List, List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Ss is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  @DisplayName("Test new AttributesEntityView(List, List, List); given '42'; when ArrayList() add '42'; then return Ss is ArrayList()")
  void testNewAttributesEntityView_given42_whenArrayListAdd42_thenReturnSsIsArrayList() {
    // Arrange
    ArrayList<String> cs = new ArrayList<>();

    ArrayList<String> ss = new ArrayList<>();
    ss.add("42");
    ss.add("foo");

    // Act and Assert
    assertEquals(ss, (new AttributesEntityView(cs, ss, new ArrayList<>())).getSs());
  }

  /**
   * Test {@link AttributesEntityView#AttributesEntityView(List, List, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return Cs is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  @DisplayName("Test new AttributesEntityView(List, List, List); given 'foo'; when ArrayList() add 'foo'; then return Cs is ArrayList()")
  void testNewAttributesEntityView_givenFoo_whenArrayListAddFoo_thenReturnCsIsArrayList() {
    // Arrange
    ArrayList<String> cs = new ArrayList<>();
    cs.add("foo");
    ArrayList<String> ss = new ArrayList<>();

    // Act
    AttributesEntityView actualAttributesEntityView = new AttributesEntityView(cs, ss, new ArrayList<>());

    // Assert
    assertTrue(actualAttributesEntityView.getSh().isEmpty());
    assertTrue(actualAttributesEntityView.getSs().isEmpty());
    assertEquals(cs, actualAttributesEntityView.getCs());
  }

  /**
   * Test {@link AttributesEntityView#AttributesEntityView(List, List, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return Sh size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  @DisplayName("Test new AttributesEntityView(List, List, List); given 'foo'; when ArrayList() add 'foo'; then return Sh size is one")
  void testNewAttributesEntityView_givenFoo_whenArrayListAddFoo_thenReturnShSizeIsOne() {
    // Arrange
    ArrayList<String> cs = new ArrayList<>();
    ArrayList<String> ss = new ArrayList<>();

    ArrayList<String> sh = new ArrayList<>();
    sh.add("foo");

    // Act
    AttributesEntityView actualAttributesEntityView = new AttributesEntityView(cs, ss, sh);

    // Assert
    List<String> sh2 = actualAttributesEntityView.getSh();
    assertEquals(1, sh2.size());
    assertEquals("foo", sh2.get(0));
    assertTrue(actualAttributesEntityView.getCs().isEmpty());
    assertTrue(actualAttributesEntityView.getSs().isEmpty());
  }

  /**
   * Test {@link AttributesEntityView#AttributesEntityView(List, List, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return Ss size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  @DisplayName("Test new AttributesEntityView(List, List, List); given 'foo'; when ArrayList() add 'foo'; then return Ss size is one")
  void testNewAttributesEntityView_givenFoo_whenArrayListAddFoo_thenReturnSsSizeIsOne() {
    // Arrange
    ArrayList<String> cs = new ArrayList<>();

    ArrayList<String> ss = new ArrayList<>();
    ss.add("foo");

    // Act
    AttributesEntityView actualAttributesEntityView = new AttributesEntityView(cs, ss, new ArrayList<>());

    // Assert
    List<String> ss2 = actualAttributesEntityView.getSs();
    assertEquals(1, ss2.size());
    assertEquals("foo", ss2.get(0));
    assertTrue(actualAttributesEntityView.getCs().isEmpty());
    assertTrue(actualAttributesEntityView.getSh().isEmpty());
  }

  /**
   * Test {@link AttributesEntityView#AttributesEntityView(List, List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Cs Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  @DisplayName("Test new AttributesEntityView(List, List, List); when ArrayList(); then return Cs Empty")
  void testNewAttributesEntityView_whenArrayList_thenReturnCsEmpty() {
    // Arrange
    ArrayList<String> cs = new ArrayList<>();
    ArrayList<String> ss = new ArrayList<>();

    // Act
    AttributesEntityView actualAttributesEntityView = new AttributesEntityView(cs, ss, new ArrayList<>());

    // Assert
    assertTrue(actualAttributesEntityView.getCs().isEmpty());
    assertTrue(actualAttributesEntityView.getSh().isEmpty());
    assertTrue(actualAttributesEntityView.getSs().isEmpty());
  }
}
