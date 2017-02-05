################
#   Makefile   #
# Par: J. boge #
################

# Dossiers
BIN     := bin
LIB     :=
SRC     := src

# Liste des dossiers à créer
CRDIRS  := $(BIN)

# Exécutables
APP     := App
DEFAULT := $(APP)

# Liste des exécutables
LISTEXES := $(APP)

# Source des exécutables
SRCAPP := $(SRC)/$(APP)

# Liste des sources des exécutables
SRCEXES  := $(SRCAPP)

#####################
#   Configuration   #
#####################

# Compilateur & options
JA      := java
JC      := javac
JFLAGS  := -g
OPT     :=

# Chemins
SP      := -sourcepath $(SRC)
CP      := -classpath "$(BIN):$(LIB)"
DP      := -d $(BIN)

###########################
#   Compiler & exécuter   #
###########################

# Cherche l'exécutable spécifié dans la liste des exécutables
EXE = $(findstring $(MAKECMDGOALS),$(LISTEXES))

# Si aucun exécutable n'est spécifié...
ifeq ($(strip $(EXE)),)
ifeq ($(strip $(DEFAULT)),)
# Si aucun exécutable par défaut, compile tout mais n'exécute rien
default: makedir $(SRCEXES:.java=.class) ccsuccess

else
# Si exécutable par défaut, construit et exécute celui défini par défaut
	EXE = $(DEFAULT)
endif
endif

# Cherche le fichier source de l'exécutable choisi
SRCEXE = $(filter %$(EXE).java,$(SRCEXES))

# Compile et exécute l'exécutable
$(EXE): makedir listfiles ccsource ccsuccess
	@$(JA) $(CP) $@

###################
#   Compilation   #
###################

# Définit les cibles par défaut (.java -> .class)
.SUFFIXES: .java .class

# Compiler une classe
.java.class:
	$(JC) $(JFLAGS) $(OPT) $(CP) $(DP) $*.java

# Liste les fichiers sources
listfiles:
	$(shell find $(SRC) -name "*.java" > source.txt)

# Compile tous les fichiers listés
ccsource:
	@$(JC) $(JFLAGS) $(OPT) $(DP) @source.txt

# Affiche un message confirmant le succès de la compilation
ccsuccess:
	@echo -e "\033[0;32mCompilation réussie!\033[0m"

################
#   Nettoyer   #
################

clean:
	rm -drf $(BIN)

##############
#   Autres   #
##############

# Créer les dossiers nécessaires
makedir:
	@mkdir -p $(foreach dir,$(CRDIRS),$(dir))

# Aide
help: listexes

# Afficher la liste des exécutables
listexes:
	@echo "Liste des exécutables:"
	@$(foreach exe,$(LISTEXES),echo "- $(exe)";)

# Forcer la règle
FORCE:

# Règle silencieuse
silent:
	@:
