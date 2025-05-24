# Set your OpenAI API key
import google.generativeai as genai
import os
import sys
import re
import json


# Configure Gemini API
#genai.configure(api_key=os.getenv("GOOGLE_API_KEY"))
genai.configure(api_key="AIzaSyDZKiJvW9tJgKycqYmxKNj_umloggBjWZI")

# Or directly use the key: genai.configure(api_key="YOUR_API_KEY")

# Subject names and their max scores
subjects = {
    "Aptitude Test": 50,
    "Programming Skill": 30,
    "DSA": 25,
    "OOPS": 25,
    "SE": 25,
    "CN": 25,
    "DBMS": 25,
    "OS": 25
}

print(sys.argv)

# Ensure correct number of arguments
if len(sys.argv) != len(subjects) + 1:
    print(f" Please provide exactly {len(subjects)} integer scores.")
    sys.exit(1)

# Attempt to convert inputs to integers
try:
    single_sample = [int(arg) for arg in sys.argv[1:]]
except ValueError:
    print(" Invalid input. Please provide only integer values.")
    sys.exit(1)

# Validate and map inputs to subjects
student_scores = {}
for (subject, max_marks), score in zip(subjects.items(), single_sample):
    if 0 <= score <= max_marks:
        student_scores[subject] = score
    else:
        print(f" Invalid score for {subject}: {score} (must be 0 to {max_marks}).")
        sys.exit(1)

# Display collected scores
print("\n Student Scores (from command line input):")
for subject, score in student_scores.items():
    print(f"{subject}: {score} / {subjects[subject]}")

# Calculate score percentages
score_percentages = {
    subject: (score / subjects[subject]) * 100
    for subject, score in student_scores.items()
}

# Identify weak subjects (below 50%)
weak_subjects = {
    subject: f"{percent:.0f}%"
    for subject, percent in score_percentages.items()
    if percent < 50
}

# Generate prompt for Gemini if needed
if not weak_subjects:
    print("\n Great job! All subject scores are above 50%. No recommendations needed.")
else:
    prompt = (
        "The following student has weak performance in certain subjects. "
        "For each weak subject, suggest 2 specific online learning resources (videos, tutorials, or courses), "
        "and a key focus area for improvement.\n\n"
        "Weak subjects:\n"
    )
    for subject, percent in weak_subjects.items():
        prompt += f"- {subject}: {percent}\n"

    prompt += (
        "\nFormat:\n"
        "Subject: [Name] (Score: %)\n"
        "- Recommendation 1: ...\n"
        "- Recommendation 2: ...\n"
        "- Focus Area: ...\n"
    )

    # Generate response from Gemini
    try:
        model = genai.GenerativeModel("gemini-2.0-flash-lite")
        response = model.generate_content(prompt)
        print("\n Gemini Recommendations:\n")
        print(response.text)



    except Exception as e:
        print(f"\n Gemini API Error: {e}")
