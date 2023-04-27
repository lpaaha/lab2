package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animal.Animal_DataClass
import com.example.animal.CustomAdapter
import com.example.lab2.databinding.FragmentFirstfragmentBinding


class firstfragment : Fragment() ,CustomAdapter.Listener{
    private var _binding : FragmentFirstfragmentBinding? = null
    private val binding get() = _binding!!
    var MyAnimals = ArrayList<Animal_DataClass>()
    lateinit var adapter: CustomAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var cat = Animal_DataClass("Garfield","Cat","Наукові дослідження показали, що коти можуть мати дуже позитивний вплив на здоров'я своїх господарів. Наприклад, вони можуть знижувати ризик виникнення серцево-судинних захворювань та депресії, покращувати імунну систему та зменшувати ризик розвитку алергій у дітей. Також коти відомі своєю здатністю прогнозувати погоду, надійністю і стійкістю в будь-яких умовах і здатністю допомагати в лікуванні деяких хвороб, таких як мігрень і біль в спині. Крім того, коти відомі своєю здатністю відчувати емоції та відгуки своїх господарів, і можуть бути великим комфортом в складних чи стресових ситуаціях.","https://kitcat.com.sg/wp-content/uploads/2020/07/Kit-Cat.png")
        var dog = Animal_DataClass("Charlie","Dog","Одним з цікавих фактів про собак є те, що вони можуть допомогти людям з різними видами інвалідності. Наприклад, сліпим людям вони можуть служити як провідники, а людям з недостатнім слухом - як сигнальні собаки. Крім того, собаки можуть бути надійними помічниками для людей з різними захворюваннями, такими як епілепсія, діабет, ПТСР та інші.","https://ggsc.s3.amazonaws.com/images/uploads/The_Science-Backed_Benefits_of_Being_a_Dog_Owner.jpg")
        var parrot = Animal_DataClass ("Polly","Parrot","Цікавим фактом про попугаїв є їх здатність імітувати голоси та звуки інших тварин і предметів. Деякі види попугаїв можуть повторювати слова та фрази, а також імітувати звуки домашніх тварин, дзвінкий сміх людини, звуки автомобілів та багато інших звуків.","https://cdn.punchng.com/wp-content/uploads/2019/04/26185543/Parrot.jpg")

        MyAnimals.add(cat)
        MyAnimals.add(dog)
        MyAnimals.add(parrot)
        adapter = CustomAdapter(this ,MyAnimals, this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding =FragmentFirstfragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(itemView: Int) {
        val bundle = bundleOf(secondfragment.number to itemView,
            secondfragment.description to MyAnimals[itemView].details,
            secondfragment.nameof to MyAnimals[itemView].titles,
            secondfragment.url to MyAnimals[itemView].URL,
            secondfragment.fulldescription to MyAnimals[itemView].desk2)
        findNavController().navigate(R.id.action_firstfragment_to_secondfragment, bundle)

    }
}
