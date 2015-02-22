package eu.daxiongmao.training.codify.lesson03sum;

/**
 * To process the "genome range query" algorithm. <br>
 * see https://codility.com/demo/take-sample-test/genomic_range_query
 *
 * @author Guillaume Diaz
 * @version 1.0 - January 2015
 */
public class GenomeRangeQuery {

  /**
   * This solution is based on the explanations from StackOverFlow: <br>
   * <a
   * href="http://stackoverflow.com/questions/19552754/java-codility-training-genomic-range-query">
   * http://stackoverflow.com/questions/19552754/java-codility-training-genomic-range-query</a>
   *
   * @param dnaSequence sequence to examine
   * @param queriesP queries start index P
   * @param queriesQ queries end index P
   * @return This return the consecutive answers to all given queries of a specific DNA sequence
   */
  public int[] solution(final String dnaSequence, final int[] queriesP, final int[] queriesQ) {

    /*
     * The idea is to have 1 array for each nucleotide.
     * Each occurrence of a genom will increase the next value
     * == We will save the reference of the next occurrence.
     * genoms[0][] == array for A
     * genoms[1][] == array for C
     * genoms[2][] == array for G
     * ... no need of an array for T, since '4' will be the default fail-over value later on
     * 
     * We need an array of length+1 to handle the first 0 case.
     * Otherwise we need to use a if(i>0) everytime
     */
    final int genoms[][] = new int[3][dnaSequence.length() + 1];

    // #### Step 1: Analyze DNA sequence
    for (int i = 0; i < dnaSequence.length(); i++) {
      // Get current genome
      short a = 0;
      short c = 0;
      short g = 0;
      switch (dnaSequence.charAt(i)) {
        case 'A':
          a = 1;
          break;
        case 'C':
          c = 2;
          break;
        case 'G':
          g = 3;
          break;
        default:
          // Worst case scenario, genome 'T', discard.
          break;
      }
      // Update registers
      genoms[0][i + 1] = genoms[0][i] + a;
      genoms[1][i + 1] = genoms[1][i] + c;
      genoms[2][i + 1] = genoms[2][i] + g;
    }

    // #### Step 2: Compute queries
    final int result[] = new int[queriesP.length];
    for (int queryId = 0; queryId < queriesP.length; queryId++) {
      // !! The sum array are 1 based, not 0 !!
      // We need to include P & Q
      final int fromIndex = queriesP[queryId];
      final int toIndex = queriesQ[queryId] + 1;

      // If end value != start value then a genom occurred !

      if (genoms[0][toIndex] - genoms[0][fromIndex] > 0) {
        result[queryId] = 1;
      } else if (genoms[1][toIndex] - genoms[1][fromIndex] > 0) {
        result[queryId] = 2;
      } else if (genoms[2][toIndex] - genoms[2][fromIndex] > 0) {
        result[queryId] = 3;
      } else {
        result[queryId] = 4;
      }
    }

    return result;
  }

  /**
   * @deprecated this is an O(n^2) solution. <br>
   *             It is not efficient because it doesn't use any sum counter.
   */
  @Deprecated
  public int[] slowSolution(final String dnaSequence, final int[] queriesP, final int[] queriesQ) {
    // To improve performances, save length reference into a dedicated value
    final int nbOfQueries = queriesP.length;

    // Transform given DNA sequence into an array of integer, to improve later performances
    final int dnaSequenceInt[] = new int[dnaSequence.length()];
    for (int i = 0; i < dnaSequence.length(); i++) {
      dnaSequenceInt[i] = getGenomeValue(dnaSequence.charAt(i));
    }

    // Compute queries
    final int result[] = new int[nbOfQueries];
    for (int queryIndex = 0; queryIndex < nbOfQueries; queryIndex++) {
      int minimalImpactFactor = 4;

      // Process current query K
      for (int genomeIndex = queriesP[queryIndex]; genomeIndex <= queriesQ[queryIndex]; genomeIndex++) {
        final int currentImpactFactor = dnaSequenceInt[genomeIndex];
        if (currentImpactFactor < minimalImpactFactor) {
          minimalImpactFactor = currentImpactFactor;
          // min. nucleotide 'A' is the lowest
          if (minimalImpactFactor == 1) {
            break;
          }
        }
      }

      // Save query result
      result[queryIndex] = minimalImpactFactor;
    }

    return result;
  }

  private int getGenomeValue(final char genomeSample) {
    int result = 0;
    switch (genomeSample) {
      case 'A':
        result = 1;
        break;
      case 'C':
        result = 2;
        break;
      case 'G':
        result = 3;
        break;
      default:
        // Worst case scenario
        result = 4;
        break;
    }
    return result;
  }

}
