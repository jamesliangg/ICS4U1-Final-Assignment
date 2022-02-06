# ICS4U1-Final-Assignment

Working on macOS Monterey V12.0.1 using Visual Studio Code

## Problem
A growing number of Canadians say the state of race relations in the country is poor, with Black and Indigenous people the most likely to say issues around racism are worsening.  As well, incidents targeting Chinese and South Asian people increased.

Only one in four Black respondents said "opportunities for everyone to succeed" have improved over the past decade, indicating most Black Canadians believe progress on racism and equity has either worsened or stagnated. The response was similar among Indigenous people: 51 per cent said the state of race relations are generally good, down slightly from 56 per cent in 2019. The perception of Black and Indigenous people is, in some cases, starkly different from those of white respondents to the survey, who were generally offered a more positive assessment of the state of racism in Canada.

Those findings are among the results of a nationwide survey released today by the Canadian Race Relations Foundation (CRRF), a Crown corporation dedicated to the elimination of racism.

## How does your program address the problem?
My program looks for potentially biased words in headlines based on a csv file that the user can edit. The provided csv file has some words that will be detected upon examination of article headlines. It then reports to the user the amount of biased words detected in the headline of the selected article.

## How does your program work?
My program utilizes JOptionPanes and JFrames for all interaction with the user. 

The user is first prompted with an option to play background music. If the user chooses to play music, they are prompted with a variety of songs from an array created from a csv file. The program then runs a method that utilizes javax.sound and java.net to play the music.

The program then parses through multiple RSS feeds from different news networks and creates an object for each article in an Array List. The program also parses through the bias.csv to and creates a 1D array.

The user is then prompted to select a news network from a predefined array. After selecting the news network, the articles from said network are presented. The user can then pick an article and more information will be shown such as title, publication date, and author (if applicable). The program will also scan the headline for biased words from the biased words array created previously. It will then report to the user what it found. The user can then use the “Close” or “Read Article” button, the “Close” button will do a System.exit(); to close the program while the “Read Article” button will close the JFrame and then call a method to open the article in the default browser.

## UML
![](https://res.cloudinary.com/dtwco1l6i/image/upload/v1644162464/ICS4U%20Blog/Summative/Summative_UML.drawio_y8pemi.png)

## What are the key features of your program? (use a separate paragraph for each key feature)
- Reads RSS news feeds from: CBC, CTV, BBC, CNBC, NYT, HKFP.
- Background music can be selected from a variety of choices.
- JOptionPane and JFrame for user interface.]
- Users can add words to the biased words CSV as they like. Future headlines will then be examined for additional words.
- Background music can also be added to the CSV with the name and URL of the wav file.

Music:
---
- Kupla https://www.youtube.com/channel/UCKfqkjTS2gp-vsOiXkzKjcA
- Khaim https://www.khaimmusic.com/
- Jennifer Walton https://youtu.be/lNk17x5tu0g
- Composerily https://youtu.be/Sunzicsn94o
