\# 🎮 Memory Match Game -- Java Edition

!\[Java\](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
!\[OOP\](https://img.shields.io/badge/OOP-Practice-blueviolet?style=for-the-badge)
!\[Platform\](https://img.shields.io/badge/Platform-Windows%2010-lightgrey?style=for-the-badge)

\-\--

\## 🧠 Overview

\*\*Memory Match Game\*\* is a classic interactive Java game designed to
challenge your memory and provide a fun, responsive experience. Built
with Java\'s AWT and Swing, it allows players to uncover matching number
pairs across multiple board sizes -- all enhanced with audio and visual
effects.

\-\--

\## 🎯 Why This Project?

\> \"Learn by building!\" This project was developed as a \*\*final OOP
course project\*\* with these key goals:

\- 👨‍💻 Practice real-world Java and GUI development - 🧩 Reinforce
object-oriented principles: encapsulation, inheritance, modularity - 🔊
Integrate multimedia (sound effects) into UI interactions - 🎓 Showcase
understanding of software design and event-driven programming

\-\--

\## 🖼️ Screenshots

\### 📋 Game Menu (Board Size Selection) !\[Menu
Screenshot\](images/menu.png) \<!\-- Replace with actual image path
\--\>

\### 🎮 Gameplay - Matching Phase !\[Gameplay
Screenshot\](images/game.png) \<!\-- Replace with actual image path
\--\>

\### 🏆 Win Screen !\[Win Screenshot\](images/winning.png) \<!\--
Replace with actual image path \--\>

\-\--

\## 🕹️ Features

\- ✅ Choose board sizes: \`2x2\`, \`4x4\`, \`6x6\`, \`8x8\` - ✅ Popup
messages and notifications - ✅ Match success and mismatch audio
feedback - ✅ Tracks progress and shows match percentage - ✅ Polished
game loop with restart and exit dialogs

\-\--

\## 🛠 Tech Stack

\| Tool \| Description \| \|\-\-\-\-\--\|\-\-\-\-\-\-\-\-\-\-\-\--\| \|
Java \| Main programming language \| \| AWT/Swing \| GUI components \|
\| Eclipse \| IDE for development \| \| Windows 10 \| Target platform \|
\| Audio System \| Sound effect handling \|

\-\--

\## 🧩 How to Play

1\. 🎲 Run the program from the \`Rashi.java\` class. 2. 🧮 Select the
board size (e.g., \`4x4\`). 3. 🖱 Click two buttons to reveal their
numbers. 4. ✅ If they match --- great! If not --- try again. 5. 🏁
Continue until all pairs are found. 6. ❌ Close the game to exit, with
confirmation.

\-\--

\## 📂 File Structure

\`\`\`bash 📁 src/ ┣ 📄 Rashi.java \# Main class ┣ 📄 Logical.java \#
Game logic + validation ┣ 📄 CenteredFrame.java \# Gameboard UI ┣ 📄
StartFrame.java \# Menu + size selection ┣ 📄 AePlayWave.java \# Sound
management ┗ 📁 sounds/ \# .wav audio files
