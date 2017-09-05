package de.moritzf.jtopia.configurator;

import de.moritzf.nlp.jtopia.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Helper class to provide configurations for the tagger-models integrated in this project.
 */
public class Configurator {

    /**
     * The constant STOPWORD_ENGLISH.
     */
    public static final String STOPWORD_ENGLISH = "stopword-english-long.stopwords";
    /**
     * The constant STOPWORD_ENGLISH_LONG.
     */
    public static final String STOPWORD_ENGLISH_LONG = "stopword-english.stopwords";
    /**
     * The constant STOPWORD_GERMAN.
     */
    public static final String STOPWORD_GERMAN = "stopword-german.stopwords";
    /**
     * The constant STOPWORD_DANISH.
     */
    public static final String STOPWORD_DANISH = "stopword-danish.stopwords";
    /**
     * The constant STOPWORD_DUTCH.
     */
    public static final String STOPWORD_DUTCH = "stopword-dutch.stopwords";
    /**
     * The constant STOPWORD_FRENCH.
     */
    public static final String STOPWORD_FRENCH = "stopword-french.stopwords";
    /**
     * The constant STOPWORD_PORTUGUESE.
     */
    public static final String STOPWORD_PORTUGUESE = "stopword-portuguese.stopwords";
    /**
     * The constant STOPWORD_SPANISH.
     */
    public static final String STOPWORD_SPANISH = "stopword-spanish.stopwords";
    /**
     * The constant STOPWORD_SWEDISH.
     */
    public static final String STOPWORD_SWEDISH = "stopword-swedish.stopwords";


    /**
     * The constant DEFAULT_ENGLISH_LEXICON.
     */
    public static final String DEFAULT_ENGLISH_LEXICON = "default-english-lexicon.txt";

    /**
     * The constant OPENNLP_ENGLISH_POS_MAXENT.
     */
    public static final String OPENNLP_ENGLISH_POS_MAXENT = "opennlp-en-pos-maxent.bin";


    /**
     * The constant OPENNLP_DANISH_POS_MAXENT.
     */
    public static final String OPENNLP_DANISH_POS_MAXENT = "opennlp-da-pos-maxent.bin";

    /**
     * The constant OPENNLP_GERMAN_POS_MAXENT.
     */
    public static final String OPENNLP_GERMAN_POS_MAXENT = "opennlp-de-pos-maxent.bin";

    /**
     * The constant OPENNLP_DUTCH_POS_MAXENT.
     */
    public static final String OPENNLP_DUTCH_POS_MAXENT = "opennlp-nl-pos-maxent.bin";

    /**
     * The constant OPENNLP_PORTUGUESE_POS_MAXENT.
     */
    public static final String OPENNLP_PORTUGUESE_POS_MAXENT = "opennlp-pt-pos-maxent.bin";

    /**
     * The constant OPENNLP_SWEDISH_POS_MAXENT.
     */
    public static final String OPENNLP_SWEDISH_POS_MAXENT = "opennlp-se-pos-maxent.bin";


    /**
     * The constant STANFORD_GERMAN_FAST.
     * Lacks distributional similarity features, but is several times faster
     * than the other alternatives.
     * Performance:
     * 96.61% overall / 86.72% unknown.
     */
    public static final String STANFORD_GERMAN_FAST = "stanford-german-fast.tagger";

    /**
     * The constant STANFORD_GERMAN_FAST_CASELESS.
     * Lacks distributional similarity features, but is several times faster
     * than the other alternatives. Caseless version.
     * Performance:
     * 96.61% overall / 86.72% unknown.
     */
    public static final String STANFORD_GERMAN_FAST_CASELESS = "stanford-german-fast-caseless.tagger";

    /**
     * The constant STANFORD_GERMAN_HGC.
     * Trained on the first 80% of the Negra corpus, which uses the STTS tagset.
     * The Stuttgart-Tübingen Tagset (STTS) is a set of 54 tags for annotating
     * German text corpora with part-of-speech labels, which was jointly
     * developed by the Institut für maschinelle Sprachverarbeitung of the
     * University of Stuttgart and the Seminar für Sprachwissenschaft of the
     * University of Tübingen. See:
     * http://www.ims.uni-stuttgart.de/projekte/CQPDemos/Bundestag/help-tagset.html
     * This model uses features from the distributional similarity clusters
     * built over the HGC (Huge German Corpus).
     * Performance:
     * 96.90% on the first half of the remaining 20% of the Negra corpus (dev set)
     * (90.33% on unknown words)
     */
    public static final String STANFORD_GERMAN_HGC = "stanford-german-hgc.tagger";

    /**
     * The constant STANFORD_GERMAN_UD.
     * This is a model that produces Universal Dependencies POS tags.
     */
    public static final String STANFORD_GERMAN_UD = "stanford-german-ud.tagger";


    /**
     * The constant STANFORD_ENGLISH_BIDIRECTIONAL_DISTSIM.
     * Trained on WSJ sections 0-18 using a bidirectional architecture and
     * including word shape and distributional similarity features.
     * Penn Treebank tagset.
     */
    public static final String STANFORD_ENGLISH_BIDIRECTIONAL_DISTSIM = "stanford-english-bidirectional-distsim.tagger";

    /**
     * The constant STANFORD_ENGLISH_CASELESS_LEFT3WORDS_DISTSIM.
     * Trained on WSJ sections 0-18 left3words architecture and includes word
     * shape and distributional similarity features. Penn tagset.  Ignores case.
     */
    public static final String STANFORD_ENGLISH_CASELESS_LEFT3WORDS_DISTSIM = "stanford-english-caseless-left3words-distsim.tagger";

    /**
     * The constant STANFORD_ENGLISH_LEFT3WORDS_DISTSIM.
     * Trained on WSJ sections 0-18 and extra parser training data using the
     * left3words architecture and includes word shape and distributional
     * similarity features. Penn tagset.
     */
    public static final String STANFORD_ENGLISH_LEFT3WORDS_DISTSIM = "stanford-english-left3words-distsim.tagger";

    /**
     * The constant STANFORD_ENGLISH_WSJ_BIDIRECTIONAL_DISTSIM.
     * Trained on WSJ sections 0-18 using a bidirectional architecture and
     * including word shape and distributional similarity features.
     * Penn Treebank tagset.
     * Performance:
     * 97.28% correct on WSJ 19-21
     * (90.46% correct on unknown words)
     */
    public static final String STANFORD_ENGLISH_WSJ_BIDIRECTIONAL_DISTSIM = "stanford-wsj-0-18-bidirectional-distsim.tagger";

    /**
     * The constant STANFORD_ENGLISH_WSJ_BIDIRECTIONAL_NODISTSIM.
     * Trained on WSJ sections 0-18 using a bidirectional architecture and
     * including word shape and distributional similarity features.
     * Penn Treebank tagset.
     * Performance:
     * 97.28% correct on WSJ 19-21
     * (90.46% correct on unknown words)
     */
    public static final String STANFORD_ENGLISH_WSJ_BIDIRECTIONAL_NODISTSIM = "stanford-wsj-0-18-bidirectional-nodistsim.tagger";

    /**
     * The constant STANFORD_ENGLISH_WSJ_LEFT3WORDS_DISTSIM.
     * Trained on WSJ sections 0-18 using the left3words architecture and
     * includes word shape and distributional similarity features. Penn tagset.
     * Caseless version.
     * Performance:
     * 97.01% correct on WSJ 19-21
     * (89.81% correct on unknown words)
     */
    public static final String STANFORD_ENGLISH_WSJ_CASELESS_LEFT3WORDS_DISTSIM = "stanford-wsj-0-18-caseless-left3words-distsim.tagger";

    /**
     * The constant STANFORD_ENGLISH_WSJ_LEFT3WORDS_DISTSIM.
     * Trained on WSJ sections 0-18 using the left3words architecture and
     * includes word shape and distributional similarity features. Penn tagset.
     * Performance:
     * 97.01% correct on WSJ 19-21
     * (89.81% correct on unknown words)
     */
    public static final String STANFORD_ENGLISH_WSJ_LEFT3WORDS_DISTSIM = "stanford-wsj-0-18-left3words-distsim.tagger";
    /**
     * Trained on WSJ sections 0-18 using the left3words architecture and
     * includes word shape features.  Penn tagset.
     * Performance:
     * 96.97% correct on WSJ 19-21
     * (88.85% correct on unknown words)
     */
    public static final String STANFORD_ENGLISH_WSJ_LEFT3WORDS_NODISTSIM = "stanford-wsj-0-18-left3words-nodistsim.tagger";
    /**
     * The constant STANFORD_FRENCH.
     * Trained on the French treebank.
     */
    public static final String STANFORD_FRENCH = "stanford-french.tagger";
    /**
     * The constant STANFORD_FRENCH_UD.
     */
    public static final String STANFORD_FRENCH_UD = "stanford-french-ud.tagger";
    /**
     * The constant STANFORD_SPANISH.
     */
    public static final String STANFORD_SPANISH = "stanford-spanish.tagger";
    /**
     * The constant STANFORD_SPANISH_DISTSIM.
     */
    public static final String STANFORD_SPANISH_DISTSIM = "stanford-spanish-distsim.tagger";
    /**
     * The constant STANFORD_SPANISH_UD.
     */
    public static final String STANFORD_SPANISH_UD = "stanford-spanish-ud.tagger";


    /**
     * Sets configuration to model.
     * Only use Configurator.STANFORD*, Configurator.DEFAULT* or Configurator.OPENNLP* as parameter for this method.
     *
     * @param config the config
     * @throws ResourceNotIncludedException the model not included exception
     */
    public static void setConfigurationToModel(String config) {

        try {
            File configFile = getResourceAsFile(config);
            String type = config.substring(0, config.indexOf("-"));
            if (type.equalsIgnoreCase("stanford")
                    || type.equalsIgnoreCase("openNLP")
                    || type.equalsIgnoreCase("default")) {
                Configuration.setTaggerType(type);
                Configuration.setModelFileLocation(configFile.getAbsolutePath());
            } else {
                throw new ResourceMismatchException(config);
            }
        } catch (IOException e) {
            throw new ResourceNotIncludedException(config);
        }

    }

    /**
     * Sets configuration to stop words.
     * <p>
     * Only use Configurator.STOPWORD* as parameter.
     *
     * @param config the config
     */
    public static void setConfigurationToStopWords(String config) {
        if (config.startsWith("stopword")) {
            try {
                HashSet<String> stopWords = new HashSet(Files.readAllLines(getResourceAsFile(config).toPath(), Charset.forName("UTF-8")));
                Configuration.setStopWords(stopWords);
            } catch (IOException e) {
                throw new ResourceNotIncludedException(config);
            }
        } else {
            throw new ResourceMismatchException(config);
        }

    }

    /**
     * Gets resource as file.
     *
     * @param resourcePath the resource path
     * @return the resource as file
     * @throws IOException the io exception
     */
    public static File getResourceAsFile(String resourcePath) throws IOException {

        InputStream in = Configurator.class.getResourceAsStream(resourcePath);
        if (in == null) {
            throw new IOException("Resource not found.");
        }

        File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");

        tempFile.deleteOnExit();

        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            //copy stream
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }

        return tempFile;


    }
}