public class Person implements Comparable<Person> {
	/***** TODO: (Part 2) create helper inner class for Identity*****/
	public class Identity {
		private String pronouns;
		private String background;


		public Identity() {
			this.pronouns = "He/Him";
			this.background = "Mid 20's Muslim Black American Male from Michigan. ";
		}

		public Identity(String pronouns, String background) {
			this.pronouns = pronouns;
			this.background = background;
		}

		public String getPronouns() {
			return pronouns;
		}
		public void setPronouns(String pronouns) {
			this.pronouns = pronouns;
		}
		public String getBackground() {
			return background;
		}
		public void setBackground(String background) {
			this.background = background;
		}

	};

	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final String DEFAULT_STORY = "Unknown";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name;
	private Identity identity;
	private int privilege;


	// CONSTRUCTORS	
	public Person(String name, String pronouns, String background, int privilege) {
		this.name = name;
		this.identity = new Identity(pronouns, background);
		this.privilege = privilege;
	}

	public Person() {
		this(DEFAULT_NAME, "He/Him", DEFAULT_STORY, DEFAULT_PRIVILEGE);
	}

	public Person(Person original) {
		if (original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.identity.getBackground(), original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setStory(String story) {
		this.identity.setBackground(story);
	}

	public void setAll(String name, String story, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setStory(story);
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}

	public Identity getIdentity() {
		return this.identity;
	}
	
	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString() {
		return "My name is " + this.name + " and " + identity.getBackground() + ". " +
		"My pronouns are " + identity.getPronouns() + ".\n" +
		"According to this calculator I ended up with " + this.privilege + " estimated privilege points.";
 
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || (!(other instanceof Person))) {
			return false;
		}

		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.identity.getBackground().equals(otherPerson.identity.getBackground()) &&
				this.privilege == otherPerson.privilege;
	};

	// INTERFACE METHODS
	@Override
	public int compareTo(Person other) {
		return Integer.compare(this.privilege, other.privilege);
	}
	/***** TODO: (Part 1) override compareTo method to implement Comparable interface*****/
	
}


