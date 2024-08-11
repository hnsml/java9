package org.omelenko.springfirst;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

@Controller
public class MyController {

    String[][] quotes = {
            {
                    "Coding like poetry should be short and concise. - Santosh Kalwar",
                    "It's not a bug; it's an undocumented feature. - Anonymous",
                    "First, solve the problem. Then, write the code. - John Johnson",
                    "Code is like humor. When you have to explain it, it's bad. - Cory House",
                    "Make it work, make it right, make it fast. - Kent Beck"
            },
            {
                    "\"Education is the most powerful weapon which you can use to change the world.\" - Nelson Mandela",
                    "\"The beautiful thing about learning is that no one can take it away from you.\" - B.B. King",
                    "\"Education is not the filling of a pail, but the lighting of a fire.\" - William Butler Yeats",
                    "\"Live as if you were to die tomorrow. Learn as if you were to live forever.\" - Mahatma Gandhi",
                    "\"The more that you read, the more things you will know. The more that you learn, the more places you'll go.\" - Dr. Seuss"
            },
            {
                    "\"All of me loves all of you.\" — Jonn Legend\n",
                    "\"I wish I had a thousand words for love, but all that comes to mind is the way you move against me while you sleep and there are no words for that.” — Brian Andreas",
                    "\"The best thing to hold onto in life is each other.\" — Audrey Hepburn",
                    "\"You are my heart, my life, my one and only thought.\" – Arthur Conan Doyle",
                    "\"I'd rather die tomorrow than live a hundred years without knowing you.\" – Pocahontas"
            },
            {
                    "'History will be kind to me for I intend to write it.' — Winston S. Churchill",
                    "'I can only note that the past is beautiful because one never realises an emotion at the time. It expands later, and thus we don't have complete emotions about the present, only about the past.' — Virginia Woolf",
                    "'The most effective way to destroy people is to deny and obliterate their own understanding of their history.' — George Orwell",
                    "'History doesn't repeat itself, but it does rhyme.' — Mark Twain",
                    "'History, like love, is so apt to surround her heroes with an atmosphere of imaginary brightness.' — James Fenimore Cooper"
            },
            {
                    "\"Do the best you can until you know better. Then when you know better, do better.\" - Maya Angelou",
                    "\"There is nothing noble in being superior to your fellow man; true nobility is being superior to your former self.\" - Ernest Hemingway",
                    "\"Stay afraid, but do it anyway. What's important is the action. You don't have to wait to be confident. Just do it and eventually the confidence will follow.\" - Carrie Fisher",
                    "\"One can choose to go back toward safety or forward toward growth. Growth must be chosen again and again; fear must be overcome again and again.\" - Abraham Maslow",
                    "\"We can’t become what we need to be by remaining what we are.\" - Oprah Winfrey"
            },
    };

    @GetMapping("/task1")
    public String task1(Model model) {
        Date date = new Date();
        String time = date.toString();
        model.addAttribute("time", time);
        return "task1";
    }
    @GetMapping("/task2")
    public String form() {
        return "task2";
    }

    @PostMapping("/echo")
    public String echo(@RequestParam("time") String time, Model model) {
        model.addAttribute("time", time);
        return "result";
    }

    @GetMapping("/task3")
    public String task3(Model model)
    {
        Random rand = new Random();
        model.addAttribute("quote", quotes[0][rand.nextInt(0, 5)]);
        return "task3";
    }

    @PostMapping("/task3_res")
    public String task3_res(@RequestParam("option") String option, Model model)
    {
        Random rand = new Random();
        model.addAttribute("option", option);
        if(Objects.equals(option, "education"))
        {
            model.addAttribute("quote", quotes[1][rand.nextInt(0, 5)]);
        }
        else if(Objects.equals(option, "relationship"))
        {
            model.addAttribute("quote", quotes[2][rand.nextInt(0, 5)]);
        }
        else if(Objects.equals(option, "history"))
        {
            model.addAttribute("quote", quotes[3][rand.nextInt(0, 5)]);
        }
        else if(Objects.equals(option, "individual_growth"))
        {
            model.addAttribute("quote", quotes[4][rand.nextInt(0, 5)]);
        }
        else
        {
            model.addAttribute("quote", quotes[0][rand.nextInt(0, 5)]);
        }
        return "task3";
    }

    @PostMapping("task3_search_res")
    public String task3_search(@RequestParam("search") String search, Model model)
    {
        ArrayList<String> search_res = new ArrayList<>();
        for(String[] a : quotes)
        {
            for(String b : a)
            {
                if(b.contains(search))
                {
                    search_res.add(b);
                }
            }
        }
        model.addAttribute("search_res", search_res);
        return "task3";
    }
}