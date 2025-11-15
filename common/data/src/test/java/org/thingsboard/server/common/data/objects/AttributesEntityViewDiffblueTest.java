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
package org.thingsboard.server.common.data.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AttributesEntityViewDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributesEntityView#equals(Object)}
   *   <li>{@link AttributesEntityView#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link AttributesEntityView#equals(Object)}
   *   <li>{@link AttributesEntityView#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributesEntityView attributesEntityView = new AttributesEntityView();

    // Act and Assert
    assertEquals(attributesEntityView, attributesEntityView);
    int expectedHashCodeResult = attributesEntityView.hashCode();
    assertEquals(expectedHashCodeResult, attributesEntityView.hashCode());
  }

  /**
   * Method under test: {@link AttributesEntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributesEntityView(), 1);
  }

  /**
   * Method under test: {@link AttributesEntityView#equals(Object)}
   */
  @Test
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
   * Method under test: {@link AttributesEntityView#equals(Object)}
   */
  @Test
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
   * Method under test: {@link AttributesEntityView#equals(Object)}
   */
  @Test
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
   * Method under test: {@link AttributesEntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributesEntityView(), null);
  }

  /**
   * Method under test: {@link AttributesEntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributesEntityView(), "Different type to AttributesEntityView");
  }

  /**
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
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  void testNewAttributesEntityView() {
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

  /**
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  void testNewAttributesEntityView2() {
    // Arrange
    ArrayList<String> cs = new ArrayList<>();
    cs.add("foo");
    ArrayList<String> ss = new ArrayList<>();

    // Act
    AttributesEntityView actualAttributesEntityView = new AttributesEntityView(cs, ss, new ArrayList<>());

    // Assert
    List<String> cs2 = actualAttributesEntityView.getCs();
    assertEquals(1, cs2.size());
    assertEquals("foo", cs2.get(0));
    assertTrue(actualAttributesEntityView.getSh().isEmpty());
    assertTrue(actualAttributesEntityView.getSs().isEmpty());
  }

  /**
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  void testNewAttributesEntityView3() {
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
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  void testNewAttributesEntityView4() {
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
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  void testNewAttributesEntityView5() {
    // Arrange
    ArrayList<String> cs = new ArrayList<>();

    ArrayList<String> ss = new ArrayList<>();
    ss.add("42");
    ss.add("foo");

    // Act
    AttributesEntityView actualAttributesEntityView = new AttributesEntityView(cs, ss, new ArrayList<>());

    // Assert
    assertTrue(actualAttributesEntityView.getCs().isEmpty());
    assertTrue(actualAttributesEntityView.getSh().isEmpty());
    assertEquals(ss, actualAttributesEntityView.getSs());
  }

  /**
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  void testNewAttributesEntityView6() {
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
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(List, List, List)}
   */
  @Test
  void testNewAttributesEntityView7() {
    // Arrange
    ArrayList<String> cs = new ArrayList<>();
    ArrayList<String> ss = new ArrayList<>();

    ArrayList<String> sh = new ArrayList<>();
    sh.add("42");
    sh.add("foo");

    // Act
    AttributesEntityView actualAttributesEntityView = new AttributesEntityView(cs, ss, sh);

    // Assert
    assertTrue(actualAttributesEntityView.getCs().isEmpty());
    assertTrue(actualAttributesEntityView.getSs().isEmpty());
    assertEquals(sh, actualAttributesEntityView.getSh());
  }

  /**
   * Method under test:
   * {@link AttributesEntityView#AttributesEntityView(AttributesEntityView)}
   */
  @Test
  void testNewAttributesEntityView8() {
    // Arrange
    AttributesEntityView obj = new AttributesEntityView();

    // Act and Assert
    assertEquals(obj, new AttributesEntityView(obj));
  }
}
