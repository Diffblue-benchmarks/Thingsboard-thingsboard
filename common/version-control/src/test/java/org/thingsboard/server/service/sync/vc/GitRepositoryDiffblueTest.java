package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.jgit.diff.DiffEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.sync.vc.GitRepository.Commit;
import org.thingsboard.server.service.sync.vc.GitRepository.Diff;
import org.thingsboard.server.service.sync.vc.GitRepository.Status;

class GitRepositoryDiffblueTest {
  /**
   * Test Commit {@link Commit#equals(Object)}, and {@link Commit#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Commit#equals(Object)}
   *   <li>{@link GitRepository.Commit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit equals(Object), and hashCode(); when other is equal; then return equal")
  void testCommitEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe",
        "jane.doe@example.org");
    GitRepository.Commit commit2 = new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe",
        "jane.doe@example.org");

    // Act and Assert
    assertEquals(commit, commit2);
    int expectedHashCodeResult = commit.hashCode();
    assertEquals(expectedHashCodeResult, commit2.hashCode());
  }

  /**
   * Test Commit {@link Commit#equals(Object)}, and {@link Commit#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Commit#equals(Object)}
   *   <li>{@link GitRepository.Commit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit equals(Object), and hashCode(); when other is equal; then return equal")
  void testCommitEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, null, "Not all who wander are lost", "JaneDoe",
        "jane.doe@example.org");
    GitRepository.Commit commit2 = new GitRepository.Commit(10L, null, "Not all who wander are lost", "JaneDoe",
        "jane.doe@example.org");

    // Act and Assert
    assertEquals(commit, commit2);
    int expectedHashCodeResult = commit.hashCode();
    assertEquals(expectedHashCodeResult, commit2.hashCode());
  }

  /**
   * Test Commit {@link Commit#equals(Object)}, and {@link Commit#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Commit#equals(Object)}
   *   <li>{@link GitRepository.Commit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit equals(Object), and hashCode(); when other is equal; then return equal")
  void testCommitEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "42", null, "JaneDoe", "jane.doe@example.org");
    GitRepository.Commit commit2 = new GitRepository.Commit(10L, "42", null, "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertEquals(commit, commit2);
    int expectedHashCodeResult = commit.hashCode();
    assertEquals(expectedHashCodeResult, commit2.hashCode());
  }

  /**
   * Test Commit {@link Commit#equals(Object)}, and {@link Commit#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Commit#equals(Object)}
   *   <li>{@link GitRepository.Commit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit equals(Object), and hashCode(); when other is equal; then return equal")
  void testCommitEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "42", "Not all who wander are lost", null,
        "jane.doe@example.org");
    GitRepository.Commit commit2 = new GitRepository.Commit(10L, "42", "Not all who wander are lost", null,
        "jane.doe@example.org");

    // Act and Assert
    assertEquals(commit, commit2);
    int expectedHashCodeResult = commit.hashCode();
    assertEquals(expectedHashCodeResult, commit2.hashCode());
  }

  /**
   * Test Commit {@link Commit#equals(Object)}, and {@link Commit#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Commit#equals(Object)}
   *   <li>{@link GitRepository.Commit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit equals(Object), and hashCode(); when other is equal; then return equal")
  void testCommitEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", null);
    GitRepository.Commit commit2 = new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", null);

    // Act and Assert
    assertEquals(commit, commit2);
    int expectedHashCodeResult = commit.hashCode();
    assertEquals(expectedHashCodeResult, commit2.hashCode());
  }

  /**
   * Test Commit {@link Commit#equals(Object)}, and {@link Commit#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Commit#equals(Object)}
   *   <li>{@link GitRepository.Commit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit equals(Object), and hashCode(); when other is same; then return equal")
  void testCommitEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe",
        "jane.doe@example.org");

    // Act and Assert
    assertEquals(commit, commit);
    int expectedHashCodeResult = commit.hashCode();
    assertEquals(expectedHashCodeResult, commit.hashCode());
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(1L, "42", "Not all who wander are lost", "JaneDoe",
        "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(commit,
        new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "Not all who wander are lost",
        "Not all who wander are lost", "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(commit,
        new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, null, "Not all who wander are lost", "JaneDoe",
        "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(commit,
        new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "42", "42", "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(commit,
        new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "42", null, "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(commit,
        new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "42", "Not all who wander are lost", "42",
        "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(commit,
        new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "42", "Not all who wander are lost", null,
        "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(commit,
        new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe",
        "john.smith@example.org");

    // Act and Assert
    assertNotEquals(commit,
        new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is different; then return not equal")
  void testCommitEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", null);

    // Act and Assert
    assertNotEquals(commit,
        new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is 'null'; then return not equal")
  void testCommitEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"), null);
  }

  /**
   * Test Commit {@link Commit#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Commit#equals(Object)}
   */
  @Test
  @DisplayName("Test Commit equals(Object); when other is wrong type; then return not equal")
  void testCommitEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe", "jane.doe@example.org"),
        "Different type to Commit");
  }

  /**
   * Test Commit getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Commit#toString()}
   *   <li>{@link GitRepository.Commit#getAuthorEmail()}
   *   <li>{@link GitRepository.Commit#getAuthorName()}
   *   <li>{@link GitRepository.Commit#getId()}
   *   <li>{@link GitRepository.Commit#getMessage()}
   *   <li>{@link GitRepository.Commit#getTimestamp()}
   * </ul>
   */
  @Test
  @DisplayName("Test Commit getters and setters")
  void testCommitGettersAndSetters() {
    // Arrange
    GitRepository.Commit commit = new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe",
        "jane.doe@example.org");

    // Act
    String actualToStringResult = commit.toString();
    String actualAuthorEmail = commit.getAuthorEmail();
    String actualAuthorName = commit.getAuthorName();
    String actualId = commit.getId();
    String actualMessage = commit.getMessage();

    // Assert
    assertEquals("42", actualId);
    assertEquals("GitRepository.Commit(timestamp=10, id=42, message=Not all who wander are lost, authorName=JaneDoe,"
        + " authorEmail=jane.doe@example.org)", actualToStringResult);
    assertEquals("JaneDoe", actualAuthorName);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("jane.doe@example.org", actualAuthorEmail);
    assertEquals(10L, commit.getTimestamp());
  }

  /**
   * Test Commit {@link Commit#Commit(long, String, String, String, String)}.
   * <p>
   * Method under test:
   * {@link GitRepository.Commit#Commit(long, String, String, String, String)}
   */
  @Test
  @DisplayName("Test Commit new Commit(long, String, String, String, String)")
  void testCommitNewCommit() {
    // Arrange and Act
    GitRepository.Commit actualCommit = new GitRepository.Commit(10L, "42", "Not all who wander are lost", "JaneDoe",
        "jane.doe@example.org");

    // Assert
    assertEquals("42", actualCommit.getId());
    assertEquals("JaneDoe", actualCommit.getAuthorName());
    assertEquals("Not all who wander are lost", actualCommit.getMessage());
    assertEquals("jane.doe@example.org", actualCommit.getAuthorEmail());
    assertEquals(10L, actualCommit.getTimestamp());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Diff#equals(Object)}
   *   <li>{@link GitRepository.Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is equal; then return equal")
  void testDiffEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertEquals(diff, diff2);
    int expectedHashCodeResult = diff.hashCode();
    assertEquals(expectedHashCodeResult, diff2.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Diff#equals(Object)}
   *   <li>{@link GitRepository.Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is equal; then return equal")
  void testDiffEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(null);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(null);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertEquals(diff, diff2);
    int expectedHashCodeResult = diff.hashCode();
    assertEquals(expectedHashCodeResult, diff2.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Diff#equals(Object)}
   *   <li>{@link GitRepository.Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is equal; then return equal")
  void testDiffEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue(null);
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue(null);
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertEquals(diff, diff2);
    int expectedHashCodeResult = diff.hashCode();
    assertEquals(expectedHashCodeResult, diff2.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Diff#equals(Object)}
   *   <li>{@link GitRepository.Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is equal; then return equal")
  void testDiffEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1(null);
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1(null);
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertEquals(diff, diff2);
    int expectedHashCodeResult = diff.hashCode();
    assertEquals(expectedHashCodeResult, diff2.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Diff#equals(Object)}
   *   <li>{@link GitRepository.Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is equal; then return equal")
  void testDiffEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2(null);
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2(null);
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertEquals(diff, diff2);
    int expectedHashCodeResult = diff.hashCode();
    assertEquals(expectedHashCodeResult, diff2.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}, and {@link Diff#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Diff#equals(Object)}
   *   <li>{@link GitRepository.Diff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff equals(Object), and hashCode(); when other is same; then return equal")
  void testDiffEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertEquals(diff, diff);
    int expectedHashCodeResult = diff.hashCode();
    assertEquals(expectedHashCodeResult, diff.hashCode());
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(null);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.MODIFY);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("/directory/foo.txt");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue(null);
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("/directory/foo.txt");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1(null);
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("/directory/foo.txt");
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2(null);
    diff.setFilePath("/directory/foo.txt");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("Not all who wander are lost");

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is different; then return not equal")
  void testDiffEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath(null);

    GitRepository.Diff diff2 = new GitRepository.Diff();
    diff2.setChangeType(DiffEntry.ChangeType.ADD);
    diff2.setDiffStringValue("42");
    diff2.setFileContentAtCommit1("Not all who wander are lost");
    diff2.setFileContentAtCommit2("Not all who wander are lost");
    diff2.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, diff2);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is 'null'; then return not equal")
  void testDiffEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, null);
  }

  /**
   * Test Diff {@link Diff#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Diff#equals(Object)}
   */
  @Test
  @DisplayName("Test Diff equals(Object); when other is wrong type; then return not equal")
  void testDiffEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    GitRepository.Diff diff = new GitRepository.Diff();
    diff.setChangeType(DiffEntry.ChangeType.ADD);
    diff.setDiffStringValue("42");
    diff.setFileContentAtCommit1("Not all who wander are lost");
    diff.setFileContentAtCommit2("Not all who wander are lost");
    diff.setFilePath("/directory/foo.txt");

    // Act and Assert
    assertNotEquals(diff, "Different type to Diff");
  }

  /**
   * Test Diff getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GitRepository.Diff}
   *   <li>{@link GitRepository.Diff#setChangeType(DiffEntry.ChangeType)}
   *   <li>{@link GitRepository.Diff#setDiffStringValue(String)}
   *   <li>{@link GitRepository.Diff#setFileContentAtCommit1(String)}
   *   <li>{@link GitRepository.Diff#setFileContentAtCommit2(String)}
   *   <li>{@link GitRepository.Diff#setFilePath(String)}
   *   <li>{@link GitRepository.Diff#toString()}
   *   <li>{@link GitRepository.Diff#getChangeType()}
   *   <li>{@link GitRepository.Diff#getDiffStringValue()}
   *   <li>{@link GitRepository.Diff#getFileContentAtCommit1()}
   *   <li>{@link GitRepository.Diff#getFileContentAtCommit2()}
   *   <li>{@link GitRepository.Diff#getFilePath()}
   * </ul>
   */
  @Test
  @DisplayName("Test Diff getters and setters")
  void testDiffGettersAndSetters() {
    // Arrange and Act
    GitRepository.Diff actualDiff = new GitRepository.Diff();
    actualDiff.setChangeType(DiffEntry.ChangeType.ADD);
    actualDiff.setDiffStringValue("42");
    actualDiff.setFileContentAtCommit1("Not all who wander are lost");
    actualDiff.setFileContentAtCommit2("Not all who wander are lost");
    actualDiff.setFilePath("/directory/foo.txt");
    String actualToStringResult = actualDiff.toString();
    DiffEntry.ChangeType actualChangeType = actualDiff.getChangeType();
    String actualDiffStringValue = actualDiff.getDiffStringValue();
    String actualFileContentAtCommit1 = actualDiff.getFileContentAtCommit1();
    String actualFileContentAtCommit2 = actualDiff.getFileContentAtCommit2();

    // Assert that nothing has changed
    assertEquals("/directory/foo.txt", actualDiff.getFilePath());
    assertEquals("42", actualDiffStringValue);
    assertEquals(
        "GitRepository.Diff(filePath=/directory/foo.txt, changeType=ADD, fileContentAtCommit1=Not all who wander"
            + " are lost, fileContentAtCommit2=Not all who wander are lost, diffStringValue=42)",
        actualToStringResult);
    assertEquals("Not all who wander are lost", actualFileContentAtCommit1);
    assertEquals("Not all who wander are lost", actualFileContentAtCommit2);
    assertEquals(DiffEntry.ChangeType.ADD, actualChangeType);
  }

  /**
   * Test {@link GitRepository#exists(String)}.
   * <ul>
   *   <li>When {@code /directory}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository#exists(String)}
   */
  @Test
  @DisplayName("Test exists(String); when '/directory'; then return 'false'")
  void testExists_whenDirectory_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(GitRepository.exists("/directory"));
  }

  /**
   * Test Status {@link Status#equals(Object)}, and {@link Status#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Status#equals(Object)}
   *   <li>{@link GitRepository.Status#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Status equals(Object), and hashCode(); when other is equal; then return equal")
  void testStatusEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashSet<String> added = new HashSet<>();
    HashSet<String> modified = new HashSet<>();
    GitRepository.Status status = new GitRepository.Status(added, modified, new HashSet<>());
    HashSet<String> added2 = new HashSet<>();
    HashSet<String> modified2 = new HashSet<>();
    GitRepository.Status status2 = new GitRepository.Status(added2, modified2, new HashSet<>());

    // Act and Assert
    assertEquals(status, status2);
    int expectedHashCodeResult = status.hashCode();
    assertEquals(expectedHashCodeResult, status2.hashCode());
  }

  /**
   * Test Status {@link Status#equals(Object)}, and {@link Status#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Status#equals(Object)}
   *   <li>{@link GitRepository.Status#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Status equals(Object), and hashCode(); when other is same; then return equal")
  void testStatusEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HashSet<String> added = new HashSet<>();
    HashSet<String> modified = new HashSet<>();
    GitRepository.Status status = new GitRepository.Status(added, modified, new HashSet<>());

    // Act and Assert
    assertEquals(status, status);
    int expectedHashCodeResult = status.hashCode();
    assertEquals(expectedHashCodeResult, status.hashCode());
  }

  /**
   * Test Status {@link Status#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Status#equals(Object)}
   */
  @Test
  @DisplayName("Test Status equals(Object); when other is different; then return not equal")
  void testStatusEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<String> added = new HashSet<>();
    added.add("foo");
    HashSet<String> modified = new HashSet<>();
    GitRepository.Status status = new GitRepository.Status(added, modified, new HashSet<>());
    HashSet<String> added2 = new HashSet<>();
    HashSet<String> modified2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(status, new GitRepository.Status(added2, modified2, new HashSet<>()));
  }

  /**
   * Test Status {@link Status#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Status#equals(Object)}
   */
  @Test
  @DisplayName("Test Status equals(Object); when other is different; then return not equal")
  void testStatusEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<String> modified = new HashSet<>();
    modified.add("foo");
    HashSet<String> added = new HashSet<>();
    GitRepository.Status status = new GitRepository.Status(added, modified, new HashSet<>());
    HashSet<String> added2 = new HashSet<>();
    HashSet<String> modified2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(status, new GitRepository.Status(added2, modified2, new HashSet<>()));
  }

  /**
   * Test Status {@link Status#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Status#equals(Object)}
   */
  @Test
  @DisplayName("Test Status equals(Object); when other is different; then return not equal")
  void testStatusEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<String> removed = new HashSet<>();
    removed.add("foo");
    HashSet<String> added = new HashSet<>();
    GitRepository.Status status = new GitRepository.Status(added, new HashSet<>(), removed);
    HashSet<String> added2 = new HashSet<>();
    HashSet<String> modified = new HashSet<>();

    // Act and Assert
    assertNotEquals(status, new GitRepository.Status(added2, modified, new HashSet<>()));
  }

  /**
   * Test Status {@link Status#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Status#equals(Object)}
   */
  @Test
  @DisplayName("Test Status equals(Object); when other is 'null'; then return not equal")
  void testStatusEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    HashSet<String> added = new HashSet<>();
    HashSet<String> modified = new HashSet<>();

    // Act and Assert
    assertNotEquals(new GitRepository.Status(added, modified, new HashSet<>()), null);
  }

  /**
   * Test Status {@link Status#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GitRepository.Status#equals(Object)}
   */
  @Test
  @DisplayName("Test Status equals(Object); when other is wrong type; then return not equal")
  void testStatusEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    HashSet<String> added = new HashSet<>();
    HashSet<String> modified = new HashSet<>();

    // Act and Assert
    assertNotEquals(new GitRepository.Status(added, modified, new HashSet<>()), "Different type to Status");
  }

  /**
   * Test Status getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GitRepository.Status#Status(Set, Set, Set)}
   *   <li>{@link GitRepository.Status#toString()}
   *   <li>{@link GitRepository.Status#getAdded()}
   *   <li>{@link GitRepository.Status#getModified()}
   *   <li>{@link GitRepository.Status#getRemoved()}
   * </ul>
   */
  @Test
  @DisplayName("Test Status getters and setters")
  void testStatusGettersAndSetters() {
    // Arrange
    HashSet<String> added = new HashSet<>();
    HashSet<String> modified = new HashSet<>();
    HashSet<String> removed = new HashSet<>();

    // Act
    GitRepository.Status actualStatus = new GitRepository.Status(added, modified, removed);
    String actualToStringResult = actualStatus.toString();
    Set<String> actualAdded = actualStatus.getAdded();
    Set<String> actualModified = actualStatus.getModified();
    Set<String> actualRemoved = actualStatus.getRemoved();

    // Assert
    assertEquals("GitRepository.Status(added=[], modified=[], removed=[])", actualToStringResult);
    assertTrue(actualAdded.isEmpty());
    assertTrue(actualModified.isEmpty());
    assertTrue(actualRemoved.isEmpty());
    assertSame(added, actualAdded);
    assertSame(modified, actualModified);
    assertSame(removed, actualRemoved);
  }
}
