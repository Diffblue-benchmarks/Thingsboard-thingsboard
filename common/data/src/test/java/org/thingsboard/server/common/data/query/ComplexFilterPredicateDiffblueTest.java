package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import org.thingsboard.server.common.data.query.ComplexFilterPredicate.ComplexOperation;

class ComplexFilterPredicateDiffblueTest {
  /**
   * Test {@link ComplexFilterPredicate#equals(Object)}, and {@link
   * ComplexFilterPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComplexFilterPredicate#equals(Object)}
   *   <li>{@link ComplexFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComplexFilterPredicate.equals(Object)",
    "int ComplexFilterPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexOperation.AND);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    ComplexFilterPredicate complexFilterPredicate2 = new ComplexFilterPredicate();
    complexFilterPredicate2.setOperation(ComplexOperation.AND);
    complexFilterPredicate2.setPredicates(new ArrayList<>());

    // Act and Assert
    assertEquals(complexFilterPredicate, complexFilterPredicate2);
    assertEquals(complexFilterPredicate.hashCode(), complexFilterPredicate2.hashCode());
  }

  /**
   * Test {@link ComplexFilterPredicate#equals(Object)}, and {@link
   * ComplexFilterPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComplexFilterPredicate#equals(Object)}
   *   <li>{@link ComplexFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComplexFilterPredicate.equals(Object)",
    "int ComplexFilterPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(null);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    ComplexFilterPredicate complexFilterPredicate2 = new ComplexFilterPredicate();
    complexFilterPredicate2.setOperation(null);
    complexFilterPredicate2.setPredicates(new ArrayList<>());

    // Act and Assert
    assertEquals(complexFilterPredicate, complexFilterPredicate2);
    assertEquals(complexFilterPredicate.hashCode(), complexFilterPredicate2.hashCode());
  }

  /**
   * Test {@link ComplexFilterPredicate#equals(Object)}, and {@link
   * ComplexFilterPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComplexFilterPredicate#equals(Object)}
   *   <li>{@link ComplexFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComplexFilterPredicate.equals(Object)",
    "int ComplexFilterPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexOperation.AND);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    // Act and Assert
    assertEquals(complexFilterPredicate, complexFilterPredicate);
    int expectedHashCodeResult = complexFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, complexFilterPredicate.hashCode());
  }

  /**
   * Test {@link ComplexFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComplexFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComplexFilterPredicate.equals(Object)",
    "int ComplexFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(null);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    ComplexFilterPredicate complexFilterPredicate2 = new ComplexFilterPredicate();
    complexFilterPredicate2.setOperation(ComplexOperation.AND);
    complexFilterPredicate2.setPredicates(new ArrayList<>());

    // Act and Assert
    assertNotEquals(complexFilterPredicate, complexFilterPredicate2);
  }

  /**
   * Test {@link ComplexFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComplexFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComplexFilterPredicate.equals(Object)",
    "int ComplexFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexOperation.OR);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    ComplexFilterPredicate complexFilterPredicate2 = new ComplexFilterPredicate();
    complexFilterPredicate2.setOperation(ComplexOperation.AND);
    complexFilterPredicate2.setPredicates(new ArrayList<>());

    // Act and Assert
    assertNotEquals(complexFilterPredicate, complexFilterPredicate2);
  }

  /**
   * Test {@link ComplexFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComplexFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComplexFilterPredicate.equals(Object)",
    "int ComplexFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<KeyFilterPredicate> predicates = new ArrayList<>();
    predicates.add(mock(KeyFilterPredicate.class));

    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexOperation.AND);
    complexFilterPredicate.setPredicates(predicates);

    ComplexFilterPredicate complexFilterPredicate2 = new ComplexFilterPredicate();
    complexFilterPredicate2.setOperation(ComplexOperation.AND);
    complexFilterPredicate2.setPredicates(new ArrayList<>());

    // Act and Assert
    assertNotEquals(complexFilterPredicate, complexFilterPredicate2);
  }

  /**
   * Test {@link ComplexFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComplexFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComplexFilterPredicate.equals(Object)",
    "int ComplexFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexOperation.AND);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    ArrayList<KeyFilterPredicate> predicates = new ArrayList<>();
    predicates.add(complexFilterPredicate);

    ComplexFilterPredicate complexFilterPredicate2 = new ComplexFilterPredicate();
    complexFilterPredicate2.setOperation(ComplexOperation.AND);
    complexFilterPredicate2.setPredicates(predicates);

    ArrayList<KeyFilterPredicate> predicates2 = new ArrayList<>();
    predicates2.add(mock(KeyFilterPredicate.class));

    ComplexFilterPredicate complexFilterPredicate3 = new ComplexFilterPredicate();
    complexFilterPredicate3.setOperation(ComplexOperation.AND);
    complexFilterPredicate3.setPredicates(predicates2);

    // Act and Assert
    assertNotEquals(complexFilterPredicate2, complexFilterPredicate3);
  }

  /**
   * Test {@link ComplexFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComplexFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComplexFilterPredicate.equals(Object)",
    "int ComplexFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexOperation.AND);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    // Act and Assert
    assertNotEquals(complexFilterPredicate, null);
  }

  /**
   * Test {@link ComplexFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComplexFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComplexFilterPredicate.equals(Object)",
    "int ComplexFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexOperation.AND);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    // Act and Assert
    assertNotEquals(complexFilterPredicate, "Different type to ComplexFilterPredicate");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ComplexFilterPredicate}
   *   <li>{@link ComplexFilterPredicate#setOperation(ComplexOperation)}
   *   <li>{@link ComplexFilterPredicate#setPredicates(List)}
   *   <li>{@link ComplexFilterPredicate#toString()}
   *   <li>{@link ComplexFilterPredicate#getOperation()}
   *   <li>{@link ComplexFilterPredicate#getPredicates()}
   *   <li>{@link ComplexFilterPredicate#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ComplexFilterPredicate.<init>()",
    "ComplexOperation ComplexFilterPredicate.getOperation()",
    "List ComplexFilterPredicate.getPredicates()",
    "FilterPredicateType ComplexFilterPredicate.getType()",
    "void ComplexFilterPredicate.setOperation(ComplexOperation)",
    "void ComplexFilterPredicate.setPredicates(List)",
    "String ComplexFilterPredicate.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ComplexFilterPredicate actualComplexFilterPredicate = new ComplexFilterPredicate();
    actualComplexFilterPredicate.setOperation(ComplexOperation.AND);
    ArrayList<KeyFilterPredicate> predicates = new ArrayList<>();
    actualComplexFilterPredicate.setPredicates(predicates);
    String actualToStringResult = actualComplexFilterPredicate.toString();
    ComplexOperation actualOperation = actualComplexFilterPredicate.getOperation();
    List<KeyFilterPredicate> actualPredicates = actualComplexFilterPredicate.getPredicates();

    // Assert
    assertEquals("ComplexFilterPredicate(operation=AND, predicates=[])", actualToStringResult);
    assertEquals(ComplexOperation.AND, actualOperation);
    assertEquals(FilterPredicateType.COMPLEX, actualComplexFilterPredicate.getType());
    assertTrue(actualPredicates.isEmpty());
    assertSame(predicates, actualPredicates);
  }
}
